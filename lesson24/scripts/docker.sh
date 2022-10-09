docker run --rm \
--network demo_network \
-d \
--name db \
-e MYSQL_ROOT_PASSWORD=root \
-e MYSQL_DATABASE=tms \
-p 3307:3306 \
mysql:latest

docker run --rm \
    --network demo_network \
	-d \
   --name tomcat-myapp \
   -p 8081:8081 \
   -v "C:\Users\ydzemyanovich\IdeaProjects\JavaEECourse\lesson24\target\lesson24-1.0-SNAPSHOT.war:/usr/local/tomcat/webapps/myapp.war" \
   tomcat:9.0.53-jdk17-temurin-focal
