#!/bin/sh
cd $(dirname $0)
set -e

# Validate
validate_cookbook_readme_html_format() {
    cookbook=$1

    echo "Validating ${cookbook}/readme.md"

    echo '<!DOCTYPE html>' > $TMP_README_FILE
    cat ${RECIPE_DIR}/${cookbook}/readme.md >> $TMP_README_FILE

    ${SCRIPTS_DIR}/html-validator.py $TMP_README_FILE
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
        echo "The following rules contains no description: ${INVALID_IDS}"
        exit 100
      fi
    fi
}

# Variables
ROOT_DIR="$(pwd)/../.."
SCRIPTS_DIR=$(pwd)
RECIPE_DIR="${ROOT_DIR}/recipes"
TMP_README_FILE=/tmp/readme.md.$$

# Working Dir
cd ${RECIPE_DIR}

# Main
for cookbook in *; do
  validate_cookbook_readme_html_format $cookbook
  check_if_contains_rules_without_description $cookbook
done
