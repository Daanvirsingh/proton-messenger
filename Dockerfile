# Stage 1: Build the application
FROM gradle:7.4.2-jdk17 as build
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle build --no-daemon

# Stage 2: Create the Docker final image
FROM openjdk:17-oracle
EXPOSE 8080
COPY --from=build /home/gradle/src/build/libs/proton-messenger-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]