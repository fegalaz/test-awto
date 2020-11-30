FROM openjdk:8
COPY "build/libs/testAwto-0.0.1-SNAPSHOT" "test.jar"
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "test.jar"]
