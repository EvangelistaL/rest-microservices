FROM openjdk:17
COPY target/user-api-0.0.1-SNAPSHOT.jar /app/user-api.jar
WORKDIR /app
ENTRYPOINT ["java", "-jar", "user-api.jar"]
EXPOSE 8080