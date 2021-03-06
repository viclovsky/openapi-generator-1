#!/bin/sh

SCRIPT="$0"
echo "# START SCRIPT: $SCRIPT"

while [ -h "$SCRIPT" ] ; do
  ls=`ls -ld "$SCRIPT"`
  link=`expr "$ls" : '.*-> \(.*\)$'`
  if expr "$link" : '/.*' > /dev/null; then
    SCRIPT="$link"
  else
    SCRIPT=`dirname "$SCRIPT"`/"$link"
  fi
done

if [ ! -d "${APP_DIR}" ]; then
  APP_DIR=`dirname "$SCRIPT"`/..
  APP_DIR=`cd "${APP_DIR}"; pwd`
fi

executable="./modules/openapi-generator-cli/target/openapi-generator-cli.jar"

if [ ! -f "$executable" ]
then
  mvn clean package
fi

# if you've executed sbt assembly previously it will use that instead.
export JAVA_OPTS="${JAVA_OPTS} -XX:MaxPermSize=256M -Xmx1024M -DloggerPath=conf/log4j.properties"
ags="$@ generate -t modules/openapi-generator/src/main/resources/JavaSpring/libraries/spring-cloud -i modules/openapi-generator/src/test/resources/2_0/petstore.yaml -l spring -c bin/spring-cloud-feign-petstore.json -o samples/client/petstore/spring-cloud -DhideGenerationTimestamp=true,responseWrapper=HystrixCommand"

echo "Removing files and folders under samples/client/petstore/spring-cloud/src/main"
rm -rf samples/client/petstore/spring-cloud/src/main
find samples/client/petstore/spring-cloud -maxdepth 1 -type f ! -name "README.md" -exec rm {} +
java $JAVA_OPTS -jar $executable $ags
