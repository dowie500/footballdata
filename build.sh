#!/bin/bash

if [ -z ${FOOTBALLDATA_REPO_HOME} ]
then
       echo "The environemnt var - FOOTBALLDATA_REPO_HOME, for this project has not been set."
       exit 10
fi

while getopts v: option
do
	case "${option}"
	in
		v) VERSION=${OPTARG};;
	esac
done

if [ -z ${VERISON} ]
then
	echo "Version number not set - exiting....."
	exit 11
fi

echo "Version number will be set to ${VERSION}"

#Update pom file to bersionnumber above

mvn clean package
echo "MVN clean install ran successfully"
echo "Copying WAR file to tomcat directroy..."
cp ${FOOTBALLDATA_REPO_HOME}/target/footballdata-${VERSION}-SNAPSHOT.war /usr/local/tomcat9/webapps/
