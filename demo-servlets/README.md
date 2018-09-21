# Demo cases
- servlets, jsp
- filter
- session
- redirect
- forward
- basic authentication and authorization

# Tomcat:
- $TOMCAT_HOME/conf/tomcat-users.xml 

example
``<user username="user" password="user" roles="user"/>``

# Hints:
- build with `mvn clean install`
- start server with `mvn jetty-run`
- open: http://localhost:8080/

# security:
- use tomcat or payara
- uncomment configuration in web.xml 
