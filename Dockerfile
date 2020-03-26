FROM openjdk:11
COPY build/libs /usr/src/myapp
WORKDIR /usr/src/myapp

EXPOSE 8080
ENTRYPOINT java -jar stock-0.0.1-SNAPSHOT.jar

LABEL maintainer="carlitos"
