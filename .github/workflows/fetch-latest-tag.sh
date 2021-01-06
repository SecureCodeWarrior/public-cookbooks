#!/bin/sh

curl -s \
  -H "Accept: application/vnd.github.v3+json" \
  -H "Authorization: token ${CUSTOM_GITHUB_TOKEN}" \
  https://api.github.com/repos/SecureCodeWarrior/public-cookbooks/releases/tags/latest |
    jq -c '.id'
