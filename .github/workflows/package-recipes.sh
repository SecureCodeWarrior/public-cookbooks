#!/bin/sh
cd $(dirname $0)

# Variables
ROOT_DIR="$(pwd)/../.."
RECIPE_DIR="${ROOT_DIR}/recipes"

# Working Dir
cd ${RECIPE_DIR}

# Main
for recipe in *; do
  pkg_name="$(basename $recipe).zip"
  echo "Generating ${pkg_name}"
  (cd $recipe && zip -r ${ROOT_DIR}/${pkg_name} *) || exit 100
done
