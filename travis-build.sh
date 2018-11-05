#!/bin/bash
set -ev

if [ "${TRAVIS_PULL_REQUEST}" = "false" ]; then
	./gradlew clean gnagCheck
else
	./gradlew clean gnagReport -PauthToken="${GNAG_AUTH_TOKEN}" -PissueNumber="${TRAVIS_PULL_REQUEST}"
fi