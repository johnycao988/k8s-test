FROM 10.39.101.226:5000/frolvlad/alpine-oraclejdk8:slim
VOLUME /tmp
ADD k8s-test-1.0.jar app.jar
ENV SERVICE_NAME cloud-security-client
ENV SERVICE_TAGS test
EXPOSE 3000
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]