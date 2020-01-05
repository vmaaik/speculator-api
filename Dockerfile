FROM openjdk:12

LABEL maintainer="vmaaik@gmail.com"

EXPOSE 8080

ARG JAR_FILE=target/speculator-api-0.0.1-SNAPSHOT.jar

ADD ${JAR_FILE} speculator-api.jar

ENTRYPOINT ["java","-jar","speculator-api.jar"]