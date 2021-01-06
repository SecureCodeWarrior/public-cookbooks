#!/bin/sh

curl -s \
  -H "Accept: application/vnd.github.v3+json" \
  -H "Authorization: token ${CUSTOM_GITHUB_TOKEN}" \
  https://api.github.com/repos/SecureCodeWarrior/public-cookbooks/releases |
    jq -c '[ .[] | select( .tag_name == "latest" and .draft == true ) ] | .[] .id'
