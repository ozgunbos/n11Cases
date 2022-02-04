FROM maven:3.8.4-jdk-11 AS build
WORKDIR /usr/share/wow
RUN chmod 777 /usr/share/wow/
ENTRYPOINT mvn clean test -Dtest=CucumberRunner -Dbrowser.name=chrome -Denv.type=uat
