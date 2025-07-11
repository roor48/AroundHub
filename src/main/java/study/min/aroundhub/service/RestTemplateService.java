package study.min.aroundhub.service;

import org.springframework.http.ResponseEntity;
import study.min.aroundhub.dto.MemberDTO;

public interface RestTemplateService {

    public String getAroundHub();

    public String getName1();
    public String getName2();

    public ResponseEntity<MemberDTO> postDTO();

    public ResponseEntity<MemberDTO> addHeader();
}
