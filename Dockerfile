FROM gradle:8.5.0-jdk21 AS build
WORKDIR /app
COPY . .
RUN ./gradlew bootJar

FROM eclipse-temurin:21-jdk
WORKDIR /app
COPY --from=build /app/build/libs/*.jar app.jar
CMD ["java", "-jar", "app.jar"]

