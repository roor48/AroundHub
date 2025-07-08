package study.min.aroundhub.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import study.min.aroundhub.dto.MemberDTO;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/put-api") // http://locallhost:8080/api/v1/put-api/*
public class PutController {

    @PutMapping("/default")
    public String putMethod() {
        return "Hello World!";
    }

    @PutMapping("/member")
    public String postMember(@RequestBody Map<String, String> map) {
        StringBuilder sb = new StringBuilder();

        map.forEach((k, v) -> sb.append(k).append(": ").append(v).append("\n"));

        return sb.toString();
    }

    @PutMapping("/member1")
    public String putMember1(@RequestBody MemberDTO memberDTO) {
        return memberDTO.toString();
    }

    @PutMapping("/member2")
    public MemberDTO putMember2(@RequestBody MemberDTO memberDTO) {
        return memberDTO;
    }

    @PutMapping("/member3")
    public ResponseEntity<MemberDTO> putMember3(@RequestBody MemberDTO memberDTO) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(memberDTO);
    }
}
