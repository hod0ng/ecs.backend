FROM amazoncorretto:17-alpine AS build

WORKDIR /app

COPY . .

RUN ./mvnw package -DskipTests

FROM public.ecr.aws/amazoncorretto/amazoncorretto:17-alpine

WORKDIR /app

COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
