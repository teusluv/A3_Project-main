FROM eclipse-temurin:21-jdk-jammy AS build-image

WORKDIR /to-build-app

COPY . .

RUN ./mvnw clean package -DskipTests
RUN ./mvnw dependency:go-offline

FROM eclipse-temurin:21-jre-jammy

WORKDIR /app

COPY --from=build-image /to-build-app/target/*.jar /app/app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app/app.jar"]