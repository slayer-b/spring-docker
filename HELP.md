
1) mvn clean package
2) docker build --build-arg JAR_FILE=target/spring-docker-0.0.1-SNAPSHOT.jar -t myorg/myapp .
3) docker run --publish 8080:8080 myorg/myapp
4) set authentication
project uses basic authentication
user name / user password:
user
password
5) make your requests
url: http://localhost:8080/todos/
with different methods
