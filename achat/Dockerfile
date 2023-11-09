FROM openjdk:11-jre-slim

WORKDIR /app

COPY target/*.jar /app.jar
EXPOSE 8089
ENTRYPOINT ["java", "-jar", "/achat-1.0"]
