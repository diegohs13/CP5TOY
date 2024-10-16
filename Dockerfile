FROM ubuntu:latest AS build

RUN apt-get update && apt-get install openjdk-21-jdk maven -y
COPY . .
RUN mvn clean install

FROM openjdk:21-jdk-slim
EXPOSE 8080  # Expor a porta para comunicação

COPY --from=build /target/*.jar /app.jar

# Usar a variável de ambiente PORT no comando de entrada
ENTRYPOINT ["sh", "-c", "java -jar /app.jar --server.port=${PORT}"]
