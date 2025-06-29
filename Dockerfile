FROM openjdk:17-jdk-slim

WORKDIR /app

COPY . .

RUN apt-get update && \
    apt-get install -y maven && \
    mvn clean package -DskipTests

CMD ["java", "-jar", "target/project_1-1.0-SNAPSHOT.jar"]
