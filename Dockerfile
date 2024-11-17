FROM amazoncorretto:21

WORKDIR /app

COPY app/gradlew .
COPY app/gradle/wrapper/gradle-wrapper.jar gradle/wrapper/gradle-wrapper.jar
COPY app/gradle/wrapper/gradle-wrapper.properties gradle/wrapper/gradle-wrapper.properties
COPY app/ .

RUN chmod +x gradlew

RUN ./gradlew build

EXPOSE 8080

CMD ["java", "-jar", "app/build/libs/app-0.0.1-SNAPSHOT.jar"]


