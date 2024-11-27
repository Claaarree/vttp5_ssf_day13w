FROM openjdk:23-jdk

ARG APP_DIR=/app

WORKDIR ${APP_DIR}

COPY .mvn .mvn
COPY src src
COPY mvnw .
COPY mvnw.cmd .
COPY pom.xml .

RUN chmod a+x ./mvnw && ./mvnw clean package -Dmaven.tests.skip=true

ENV SERVER_PORT=4000

EXPOSE ${SERVER_PORT}

ENTRYPOINT java -jar target/vttp5a-ssf-day13w-0.0.1-SNAPSHOT.jar --dataDir=src/main/resources/data