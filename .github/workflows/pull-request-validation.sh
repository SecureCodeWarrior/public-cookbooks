#!/bin/sh
cd $(dirname $0)
set -e

# Begins with
beginswith() { case $2 in "$1"*) true;; *) false;; esac; }

# Validate
validate_cookbook_readme_html_format() {
    cookbook=$1

    echo "Validating ${cookbook}/readme.md"

    echo '<!DOCTYPE html>' > $TMP_README_FILE
    cat ${RECIPE_DIR}/${cookbook}/readme.md >> $TMP_README_FILE

    MESSAGE=$(${SCRIPTS_DIR}/html-validator.py $TMP_README_FILE)

    if [ ! "$?" = "0" ]; then
      add_comment_to_pull_request $MESSAGE
      exit 101
    fi
}

check_if_contains_rules_without_description() {
    cookbook=$1
    rule_file="${RECIPE_DIR}/${cookbook}/rules.sensei"

    if [ -f $rule_file ]; then
      echo "Validating ${cookbook}/rules.sensei"

      INVALID_IDS=$(
        cat $rule_file | jq '. .rules | [ .[] | select( .model.ruleShortDescription == "" ) ] | .[] .model.ruleID'
      )

      if [ ! "${INVALID_IDS}" = "" ]; then
        add_comment_to_pull_request "The following rules contains no description: ${INVALID_IDS}"
        exit 100
      fi
    fi
}

find_rules_places_in_the_wrong_folder() {
  recipe_dir=${RECIPE_DIR/${ROOT_DIR}/}

  find ${ROOT_DIR} -name 'rules.sensei' | while read file; do

    if ! beginswith "${RECIPE_DIR}" $file; then
      message="Sensei Cookbook placed in the wrong folder:\n
- **found file**: ${file/${ROOT_DIR}/}\n
- **expected place**: ${recipe_dir}
"
      add_comment_to_pull_request "$message"
      exit 102
    fi

  done
}

add_comment_to_pull_request() {
  message=$@

  echo $message

  curl -s \
    -H "Authorization: token ${CUSTOM_GITHUB_TOKEN}" \
    -X POST -d "{\"body\": \"### Pull Request Validation Result\n${message}\"}" \
    "https://api.github.com/repos/SecureCodeWarrior/public-cookbooks/issues/${PULL_REQUEST_NUMBER}/comments" > /dev/null
}

# Variables
ROOT_DIR="$(pwd)/../.."
SCRIPTS_DIR=$(pwd)
RECIPE_DIR="${ROOT_DIR}/recipes"
TMP_README_FILE=/tmp/readme.md.$$
PULL_REQUEST_NUMBER=$1

# Working Dir
cd ${RECIPE_DIR}

# Main
for cookbook in *; do
  validate_cookbook_readme_html_format $cookbook
  check_if_contains_rules_without_description $cookbook
done

find_rules_places_in_the_wrong_folder