FROM openjdk:11
COPY build/libs/event-bus-0.1.0-SNAPSHOT-all.jar /usr/src/event-bus.jar
WORKDIR /usr/src/
EXPOSE 8080
CMD ["java", "-jar", "event-bus.jar"]
