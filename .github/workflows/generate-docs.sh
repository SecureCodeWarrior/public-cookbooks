#!/bin/sh
cd $(dirname $0)

# Calculate the number of recipes available in a given cookbook
calc_num_recipes() {
    cookbook=$1
    cat ${RECIPE_DIR}/${cookbook}/rules.sensei| jq '.rules' | jq length
}

# Reads the cookbook title. Ideally, it should be the first line, but
# this routine will be a bit more permissive and allow small mistakes like
# empty strings at the beginning, or using a different title mark (e.g. ### instead of #)
read_cookbook_title(){
    cookbook=$1
    sed '/^#/!d' ${RECIPE_DIR}/${cookbook}/readme.md | head -n 1 | sed '/^#/!d;s/##* \(.*\)$/\1/'
}

# Reads the cookbook summary
read_cookbook_summary() {
    cookbook=$1
    sed '/^#/,/^$/!d;/^#/d;s/ *$//;s/\.\.*$//' ${RECIPE_DIR}/${cookbook}/readme.md
}

# Tries to read the coobook description details.
read_cookbook_details() {
    cookbook=$1
    sed '/^#/,/^$/d' ${RECIPE_DIR}/${cookbook}/readme.md
}

# Reads the README file until the Extras section
read_readme_upper_body(){
    cat ${ROOT_DIR}/readme.md | sed '/^# /,/## Extras/!d;/## Extras/d'
}

# Reads the README lower body sections - starting from the Extras section
read_readme_lower_body(){
    echo '## Extras'
    cat ${ROOT_DIR}/readme.md | sed '/^# /,/## Extras/d'
}

# Generate the index file
generate_index(){
    cd ${RECIPE_DIR}

    for cookbook in *; do
        title=$(read_cookbook_title ${cookbook})
        summary=$(read_cookbook_summary ${cookbook})
        details=$(read_cookbook_details ${cookbook})
        num_recipes=$(calc_num_recipes ${cookbook})

        cat <<EOF
<details>
<summary><strong>${title}</strong> - ${num_recipes} recipe(s) -
<a href="${BASE_GH_URL}/LATEST_RELEAST/${cookbook}.zip">download zip</a>

${summary}
</summary>

${details}
</details>
EOF
    done
}

# Variables
ROOT_DIR="$(pwd)/../.."
RECIPE_DIR="${ROOT_DIR}/recipes"
BASE_GH_URL="https://github.com/SecureCodeWarrior/public-cookbooks/releases/download/"
DOC_FILE="${ROOT_DIR}/docs/readme.md"
DOC_DIR=$(dirname ${DOC_FILE})

# Main
mkdir -p ${DOC_DIR}

cat <<EOF > $DOC_FILE
$(read_readme_upper_body)

$(generate_index)

$(read_readme_lower_body)
EOF
