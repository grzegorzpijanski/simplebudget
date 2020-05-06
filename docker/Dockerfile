FROM openjdk:11-jdk-alpine
VOLUME /tmp
EXPOSE 8080
ADD /build/libs/simplebudget-0.0.1-SNAPSHOT.jar simplebudget-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","simplebudget-0.0.1-SNAPSHOT.jar"]