FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
COPY target/product-0.0.1-SNAPSHOT.jar product.jar
ENTRYPOINT ["java", "-jar", "product.jar"]