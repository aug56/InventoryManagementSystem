# Stage 1: Build the JAR using Maven
FROM maven:3.8.4-openjdk-17 AS build
COPY . .
RUN mvn clean package -DskipTests

# Stage 2: Run the JAR using Eclipse Temurin (The new standard)
FROM eclipse-temurin:17-jre-alpine
# We use a wildcard to find your JAR regardless of its name
COPY --from=build /target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
