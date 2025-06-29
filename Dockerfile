FROM openjdk:17-jdk-slim

# Set working directory inside the container
WORKDIR /app

# Copy only the built JAR file into the container
COPY target/project_1-1.0-SNAPSHOT.jar app.jar

# Run the JAR file
CMD ["java", "-jar", "app.jar"]
