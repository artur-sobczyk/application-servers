package pl.sda.simpleapp;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SimpleResource {

    @GetMapping(path = "/example/**")
    public ResponseEntity<String> getRequest() {
        return ResponseEntity.ok("hello world");
    }
}
