FROM eclipse-temurin:11-jdk-alpine as build
WORKDIR /workspace/app

COPY gradlew .
COPY gradle gradle
COPY settings.gradle settings.gradle
COPY build.gradle build.gradle
COPY src src

RUN ./gradlew bootJar

FROM eclipse-temurin:11-jdk-alpine as runtime
COPY --from=build /workspace/app/build/libs/dad-jokes-service.jar /app/dad-jokes-service.jar

CMD ["java", "-jar", "/app/dad-jokes-service.jar"]