FROM openjdk:17
COPY target/product-api-0.0.1-SNAPSHOT.jar /app/product-api.jar
WORKDIR /app
ENTRYPOINT ["java", "-jar", "product-api.jar"]
EXPOSE 8080