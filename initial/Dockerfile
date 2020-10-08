FROM adoptopenjdk/openjdk11:jdk-11.0.8_10-alpine-slim
COPY ./build/libs/*.jar app.jar
EXPOSE 8888
CMD ["java", "-jar", "/app.jar"]