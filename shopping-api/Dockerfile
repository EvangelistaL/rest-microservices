FROM openjdk:17
COPY target/shopping-api-0.0.1-SNAPSHOT.jar /app/shopping-api.jar
WORKDIR /app
ENTRYPOINT ["java", "-jar", "shopping-api.jar"]
EXPOSE 8080