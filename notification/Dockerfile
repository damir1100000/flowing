FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
COPY target/notification-0.0.1-SNAPSHOT.jar notification.jar
ENTRYPOINT ["java", "-jar", "notification.jar"]