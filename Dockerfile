FROM maven:3.9-openjdk-21 AS build

WORKDIR /app
COPY . .


RUN mvn clean package


FROM openjdk:21-jdk-slim

WORKDIR /app


EXPOSE 8080


COPY --from=build /app/target/*.jar app.jar


ENTRYPOINT ["java", "-jar", "app.jar"]
