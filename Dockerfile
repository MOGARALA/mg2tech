# Build stage
#FROM maven:3.9-eclipse-temurin-21 AS build
#WORKDIR /workspace
#COPY pom.xml .
#COPY src ./src
#RUN mvn -B clean verify

# Minimal runtime stage
FROM eclipse-temurin:21-jre
WORKDIR /app
RUN useradd --system --uid 10001 appuser
COPY --from=build /workspace/target/mg2-technologies-1.0.0.jar app.jar
USER 10001
EXPOSE 8081
ENTRYPOINT ["java", "-XX:MaxRAMPercentage=75.0", "-jar", "/app/app.jar"]
