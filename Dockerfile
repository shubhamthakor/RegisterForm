FROM openjdk:21-slim
WORKDIR /app
COPY project_1.jar app.jar
CMD ["java", "-jar", "app.jar"]
