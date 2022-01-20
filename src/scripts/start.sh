#!/usr/bin/env sh
java -jar ${project.build.finalName}*.jar
echo "Press enter to continue..."
read -r test
