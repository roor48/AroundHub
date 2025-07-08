package study.min.aroundhub.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/delete-api") // http://locallhost:8080/api/v1/delete-api/*
public class DeleteController {

    @DeleteMapping("/delete/{variable}")
    public String DeleteVariable(@PathVariable String variable) {
        // delete {variable}
        return variable;
    }
}
