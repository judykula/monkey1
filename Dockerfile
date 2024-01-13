FROM java:8

WORKDIR /home/ubuntu/app

COPY target/monkey1.jar /home/ubuntu/app

CMD ["java","-Dspring.profiles.active=dev","-Xms125m","-Xmx125m","-jar","monkey1.jar"]