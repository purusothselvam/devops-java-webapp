FROM eclipse-temurin:17-jre

WORKDIR /app

COPY devops-webapp.jar app.jar

EXPOSE 8081

ENTRYPOINT ["java", "-jar", "app.jar"]
