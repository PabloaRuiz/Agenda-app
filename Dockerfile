FROM openjdk

WORKDIR /app

COPY target/Agenda-0.0.1-SNAPSHOT.jar /app/agenda-app.jar

ENTRYPOINT ["java", "-jar", "agenda-app.jar"]
