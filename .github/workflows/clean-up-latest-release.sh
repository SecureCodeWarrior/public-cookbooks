#!/bin/sh
cd $(dirname $0)

fetch_asset_ids(){
    curl -s \
        -H "Accept: application/vnd.github.v3+json" \
        -H "Authorization: token ${CUSTOM_GITHUB_TOKEN}" \
        https://api.github.com/repos/SecureCodeWarrior/public-cookbooks/releases/${RELEASE_ID}/assets |
        jq '.[] .id'
        # https://api.github.com/repos/SecureCodeWarrior/public-cookbooks/releases |
        #     jq -c '[ .[] | select( .tag_name == "latest" and .draft == true ) ] | .[0]'
}

flush_assets(){
    IDS=$(fetch_asset_ids)

    for id in ${IDS}; do
        echo $id
        curl -s -X DELETE \
            -H "Accept: application/vnd.github.v3+json" \
            -H "Authorization: token ${CUSTOM_GITHUB_TOKEN}" \
            https://api.github.com/repos/SecureCodeWarrior/public-cookbooks/releases/assets/${id} | jq '.message'
    done
}

# Variables
ROOT_DIR="$(pwd)/../.."
RECIPE_DIR="${ROOT_DIR}/recipes"
RELEASE_ID=${RELEASE_ID:-$1}

if [ "${RELEASE_ID}" = "" ]; then
  echo "RELEASE_ID not defined"
  exit 100
fi

flush_assets