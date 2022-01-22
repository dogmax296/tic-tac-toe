#!/usr/bin/env sh
cd "$(dirname "$0")" || exit
java -jar ${project.build.finalName}-release.jar
echo "Press enter to continue . . ."
read -r test