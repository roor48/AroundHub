package study.min.aroundhub.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import study.min.aroundhub.dto.MemberDTO;
import study.min.aroundhub.service.RestTemplateService;

import java.net.URI;

@Service
public class RestTemplateServiceImpl implements RestTemplateService {

    private final Logger LOGGER = LoggerFactory.getLogger(RestTemplateServiceImpl.class);

    @Override
    public String getAroundHub() {
        URI uri = UriComponentsBuilder.fromUriString("http://localhost:9090/")
                .path("/api/server/around-hub")
                .encode()
                .build()
                .toUri();


        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity(uri, String.class);

        LOGGER.info("status code: {}", response.getStatusCode());
        LOGGER.info("body: {}", response.getBody());

        return response.getBody();
    }

    @Override
    public String getName1() {
                URI uri = UriComponentsBuilder.fromUriString("http://localhost:9090/")
                .path("/api/server/name")
                .queryParam("name", "MIN")
                .encode()
                .build()
                .toUri();


        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity(uri, String.class);

        LOGGER.info("status code: {}", response.getStatusCode());
        LOGGER.info("body: {}", response.getBody());

        return response.getBody();
    }

    @Override
    public String getName2() {
                URI uri = UriComponentsBuilder.fromUriString("http://localhost:9090/")
                .path("/api/server/path-variable/{name}")
                .encode()
                .build()
                .expand("MIN")
                .toUri();


        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity(uri, String.class);

        LOGGER.info("status code: {}", response.getStatusCode());
        LOGGER.info("body: {}", response.getBody());

        return response.getBody();
    }

    @Override
    public ResponseEntity<MemberDTO> postDTO() {
        URI uri = UriComponentsBuilder
                .fromUriString("http://localhost:9090")
                .path("/api/server/member")
                .queryParam("name", "MIN")
                .queryParam("email", "asdf@gmail.com")
                .queryParam("organization", "Study Min")
                .encode()
                .build()
                .toUri();

        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setName("MIN!!");
        memberDTO.setEmail("eee@naver.com");
        memberDTO.setOrganization("Study MIN!!!!");

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<MemberDTO> response = restTemplate.postForEntity(uri, memberDTO, MemberDTO.class);

        LOGGER.info("status code: {}", response.getStatusCode());
        LOGGER.info("body: {}", response.getBody());

        return response;
    }

    @Override
    public ResponseEntity<MemberDTO> addHeader() {
        URI uri = UriComponentsBuilder
                .fromUriString("http://localhost:9090")
                .path("/api/server/add-header")
                .encode()
                .build()
                .toUri();

        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setName("MIN");
        memberDTO.setEmail("asdf@gmail.com");
        memberDTO.setOrganization("Study Min");

        RequestEntity<MemberDTO> requestEntity = RequestEntity
                .post(uri)
                .header("around-header", "Study Min1234")
                .body(memberDTO);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<MemberDTO> response = restTemplate.exchange(requestEntity, MemberDTO.class);

        LOGGER.info("status code: {}", response.getStatusCode());
        LOGGER.info("body: {}", response.getBody());

        return response;
    }
}
