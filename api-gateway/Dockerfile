FROM openjdk:17
COPY target/api-gateway-0.0.1-SNAPSHOT.jar /app/api-gateway.jar
WORKDIR /app
ENTRYPOINT ["java", "-jar", "api-gateway.jar"]
EXPOSE 8080