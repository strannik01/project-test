FROM openjdk:8
ADD ./target/project-test-0.0.1.jar project-test-0.0.1.jar
ADD src/main/resources/* /v1.0.0/
EXPOSE 8085
ENTRYPOINT ["java", "-jar", "project-test-0.0.1.jar", "/v1.0.0"]
