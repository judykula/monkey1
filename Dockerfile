FROM java:8

WORKDIR /app

格式：`ADD <src> <dest>`复制本地文件到镜像的功能
ADD target/XX.jar /app/

CMD ["java","-Dspring.profiles.active=XX","-Xms512m","-Xmx512m","-jar","XX.jar"]