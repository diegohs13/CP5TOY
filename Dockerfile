FROM ubuntu:latest AS build

RUN apt-get update && apt-get install openjdk-21-jdk maven -y
COPY . .
RUN mvn clean install

FROM openjdk:21-jdk-slim
EXPOSE 8080

COPY --from=build /target/*.jar /app.jar

ENTRYPOINT ["sh", "-c", "java -jar /app.jar --server.port=${PORT}"]
