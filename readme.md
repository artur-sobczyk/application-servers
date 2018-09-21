#application-servers

Purpose of this repository is to provide code examples for training 
related to application servers.

Project consists of separate submodules that allows to observe some
basic Java EE features, ways of deployment to (tomcat, payara and heroku)

### links to servers:
https://www.payara.fish/downloads
https://tomcat.apache.org/download-90.cgi

## submodules:
- **client-server** - demo for basic network connection using Sockets and simple http server
- **demo-servlets** - servlets showing basic functionality od Java EE, with easy start using jetty plugin
- **simple-war** - web app that can be deployed manually or from IntelliJ
- **heroku-war** - project that can be deployed using mvn plugin or Heroku CLI

- **jetty-embedded** - server as a part of application
- **jetty-plugin** - server strated from maven plugin
- **payara-plugin** - server started from maven plugin

- **spring-boot-app** - separate application (not maven submodule) for demo purposes 
not completed yet

### Other useful resources
https://github.com/payara/Payara-Examples
https://github.com/javaee-samples/javaee7-samples 

### Some links:
- https://mvnrepository.com/artifact/fish.payara.extras/payara-micro/5.183

### payara-micro 
- start with https - java -jar payara-micro-5.183.jar --deploy simple-war.war --autoBindSsl