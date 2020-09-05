FROM openjdk:8-jdk
COPY nokia-stack-lifo.jar /target/nokia-stack-lifo.jar
ADD target/nokia-stack-lifo.jar nokia-stack-lifo.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "nokia-stack-lifo.jar"]