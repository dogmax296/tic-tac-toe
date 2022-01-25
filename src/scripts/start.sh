#!/usr/bin/env sh
# Fix current dir issue. Read more: http://hints.macworld.com/article.php?story=20041217111834902
  cd "$(dirname "$0")" || exit
# Try to use the `java` from `$JAVA_HOME` if this environment variable set correctly:
if [ -n "$JAVA_HOME" ] && [ -x "$JAVA_HOME/bin/java" ] ; then
  JAVA_CMD="$JAVA_HOME/bin/java"
fi
# ----------------------------------------------------------------------------------------------------------------------
# Try to use the `java` using `PATH` environment variable:
WHICH_JAVA=$(which java)
if [ -x "$WHICH_JAVA" ]; then
  JAVA_CMD="java"
  unset WHICH_JAVA
fi
# ----------------------------------------------------------------------------------------------------------------------
# Try to use `java` from JRE if `jre/bin/java` exists and executable:
if [ -x "jre/bin/java" ]; then
  JAVA_CMD="jre/bin/java"
fi
# ----------------------------------------------------------------------------------------------------------------------
if [ -z ${JAVA_CMD+x} ]; then
  # Throw error if `java` is not configured:
  echo "------------------------------------------------------------------------" >&2
  echo "\`java\` not defined! Install or configure JVM before using this script!" >&2
  echo "------------------------------------------------------------------------" >&2
  RETURN_CODE=1
else
  # Run tic-tac-toe game:
  $JAVA_CMD -jar ${project.build.finalName}-release.jar "$@"
  RETURN_CODE=0
fi
# ----------------------------------------------------------------------------------------------------------------------
exit $RETURN_CODE