FROM openjdk:17
COPY target/orders-service-0.0.1-SNAPSHOT.jar orders-service-0.0.1-SNAPSHOT.jar
EXPOSE 8089
ENTRYPOINT ["java","-jar","/orders-service-0.0.1-SNAPSHOT.jar"]
