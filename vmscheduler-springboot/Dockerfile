FROM openjdk:8
EXPOSE 8080
ADD target/vmscheduler-springboot-0.0.1-SNAPSHOT-spring-boot.jar docker.jar
ENTRYPOINT ["java","-jar","/docker.jar"]