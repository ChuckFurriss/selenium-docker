FROM openjdk:19-alpine

RUN apk add curl jq

#Workspace
WORKDIR /usr/share/udemy

#Add .jar under target from host
ADD target/selenium-docker.jar selenium-docker.jar
ADD target/selenium-docker-tests.jar selenium-docker-tests.jar
ADD target/libs libs

#ADD suite files
ADD book-flight-module.xml book-flight-module.xml
ADD search-module.xml search-module.xml

#ADD health check script
ADD healthcheck.sh healthcheck.sh
# BROWSER
# SE_EVENT_BUS_HOST
# MODULE
ENTRYPOINT sh healthcheck.sh