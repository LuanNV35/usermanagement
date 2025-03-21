# Dockerfile cho Eureka Server (tương tự áp dụng cho các dịch vụ khác)
FROM bellsoft/liberica-openjdk-alpine
ARG JAR_FILE=target/usermanagement.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
