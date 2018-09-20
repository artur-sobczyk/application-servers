package pl.sda.simpleapp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class SimpleAppApplication {

    public static void main(String[] args) {
        log.info("http://localhost:8080/actuator");
        log.info("http://localhost:8080/swagger-ui.html");
        SpringApplication.run(SimpleAppApplication.class, args);
    }

}
