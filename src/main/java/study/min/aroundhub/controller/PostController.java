package study.min.aroundhub.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import study.min.aroundhub.dto.MemberDTO;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/post-api") // http://locallhost:8080/api/v1/post-api/*
public class PostController {
    @PostMapping(value = "/name")
    public String getName() {
        return "Post Name";
    }

    @PostMapping("/member1")
    public String postMember1(@RequestBody Map<String, Object> postData) {
        StringBuilder sb = new StringBuilder();

        postData.forEach((k,v)->{
            sb.append(k).append(": ").append(v).append("\n");
        });

        return sb.toString();
    }

    @PostMapping("/member2")
    public String postMember2(@RequestBody MemberDTO memberDTO) {
        return memberDTO.toString();
    }
}
