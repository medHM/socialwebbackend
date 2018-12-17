FROM openjdk:8
ADD target/bibMy.jar bibMy.jar
EXPOSE 8086
ENTRYPOINT ["java","-jar","bibMy.jar"]