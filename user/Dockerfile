FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
COPY target/user-0.0.1-SNAPSHOT.jar user.jar
ENTRYPOINT ["java", "-jar", "user.jar"]