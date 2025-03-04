FROM openjdk:17-jdk-slim
WORKDIR /app

# Copy the JAR file into the container
COPY target/BookingInventry-0.0.1-SNAPSHOT.jar app.jar

# Expose port 8080
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
