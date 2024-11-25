FROM openjdk:21-jdk-slim

WORKDIR /app

COPY target/backend-1.0-SNAPSHOT.jar /app/backend.jar

EXPOSE 8081

ENTRYPOINT ["java", "-jar", "backend.jar"]
