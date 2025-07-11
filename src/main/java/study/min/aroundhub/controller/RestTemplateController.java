package study.min.aroundhub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import study.min.aroundhub.dto.MemberDTO;
import study.min.aroundhub.service.RestTemplateService;

@RestController
@RequestMapping("/api/rest-template")
public class RestTemplateController {

    private final RestTemplateService restTemplateService;

    @Autowired
    public RestTemplateController(RestTemplateService restTemplateService) {
        this.restTemplateService = restTemplateService;
    }

    @GetMapping("/around-hub")
    public String getAroundHub() {
        return restTemplateService.getAroundHub();
    }

    @GetMapping("/name1")
    public String getName1() {
        return restTemplateService.getName1();
    }

    @GetMapping("/name2")
    public String getName2() {
        return restTemplateService.getName2();
    }

    @PostMapping("/dto")
    public ResponseEntity<MemberDTO> getDto() {
        return restTemplateService.postDTO();
    }

    @PostMapping("/add-header")
    public ResponseEntity<MemberDTO> addHeader() {
        return restTemplateService.addHeader();
    }
}
