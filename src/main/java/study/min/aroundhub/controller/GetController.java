package study.min.aroundhub.controller;


import org.springframework.web.bind.annotation.*;
import study.min.aroundhub.dto.MemberDTO;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/get-api") // http://locallhost:8080/api/v1/get-api/*
public class GetController {

    @RequestMapping(value="/hello", method = RequestMethod.GET)
    public String getHello() {
        return "Hello World";
    }

    @GetMapping("/name")
    public String getName() {
        return "MyName";
    }

    @GetMapping(value="/variable1/{name1}/{name2}")
    public String getVariable1(@PathVariable(name="name1") String var1, @PathVariable(name="name2") String var2) {
        return "Hello " + var1 + ", " + var2;
    }

    @GetMapping(value="/request1")
    public String request1(@RequestParam String name, @RequestParam String email) {
        return name + ", " + email;
    }

    @GetMapping("/request2")
    public String request2(@RequestParam Map<String,String> map) {
        return map.get("name") + ", " + map.get("email");
    }

    @GetMapping(value="/request3")
    public String request3(MemberDTO memberDTO) {
        return memberDTO.toString();
    }
}
