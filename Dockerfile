# Use an official OpenJDK image
FROM openjdk:17-jdk-slim

# Set working directory
WORKDIR /app

# Copy project files
COPY . .

# If using Maven, build the project
RUN apt-get update && apt-get install -y maven
RUN mvn clean package

# Expose port (Tomcat default is 8080)
EXPOSE 8080

# Run the WAR/JAR (adjust path to your build output)
CMD ["java", "-jar", "target/yourapp.jar"]
