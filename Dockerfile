FROM public.ecr.aws/docker/library/maven:3.9-amazoncorretto-17 AS build

WORKDIR /app
COPY . .
RUN ./mvnw package -DskipTests

FROM public.ecr.aws/amazoncorretto/amazoncorretto:17
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
