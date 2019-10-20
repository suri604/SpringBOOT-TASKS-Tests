FROM openjdk:11
WORKDIR usr/src
ADD ./target/trackservice-0.0.1-SNAPSHOT.jar /usr/src/trackservice-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/usr/src/trackservice-0.0.1-SNAPSHOT.jar"]