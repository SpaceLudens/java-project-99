FROM amazoncorretto:21

WORKDIR /app

COPY . .

RUN chmod +x gradlew

RUN ./gradlew build

EXPOSE 8080

CMD ["java", "-jar", "app/build/libs/app-0.0.1-SNAPSHOT.jar"]


