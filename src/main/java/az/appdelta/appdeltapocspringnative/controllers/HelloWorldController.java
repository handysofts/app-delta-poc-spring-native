package az.appdelta.appdeltapocspringnative.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/")
public class HelloWorldController {
    @GetMapping
    public String sayHello(@RequestParam(defaultValue = "") String name) {
        log.info("Hello {}", name);
        return "Hello " + name;
    }
}
