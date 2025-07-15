package study.min.aroundhub.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import study.min.aroundhub.data.dto.ShortUrlResponseDto;
import study.min.aroundhub.data.repository.ShortUrlRepository;
import study.min.aroundhub.service.ShortUrlService;

@RestController
@RequestMapping("/short-url")
public class ShortUrlController {
    private Logger LOGGER = LoggerFactory.getLogger(ShortUrlController.class);

    @Value("${study.min.short.url.id}")
    private String CLIENT_ID;

    @Value("${study.min.short.url.secret}")
    private String CLIENT_SECRET;

    private final ShortUrlService shortUrlService;

    @Autowired
    public ShortUrlController(ShortUrlService shortUrlService) {
        this.shortUrlService = shortUrlService;
    }

    @PostMapping
    public ShortUrlResponseDto generateShortUrl(String originalUrl) {

        LOGGER.info("[generateShortUrl] perform API, CLIENT_ID : {}, CLIENT_SECRET : {}", CLIENT_ID, CLIENT_SECRET);

        return shortUrlService.generateShortUrl(CLIENT_ID, CLIENT_SECRET, originalUrl);
    }

    @GetMapping
    public ShortUrlResponseDto getShortUrl(String originalUrl) {
//        ShortUrlResponseDto shortUrlResponseDto = new ShortUrlResponseDto("ss", "ss");

        return shortUrlService.getShortUrl(CLIENT_ID, CLIENT_SECRET, originalUrl);
    }

    @PutMapping("/")
    public ShortUrlResponseDto updateShortUrl(String originalUrl) {
        return null;
    }

    @DeleteMapping("/")
    public ResponseEntity<String> deleteShortUrl(String url) {
        try {
            shortUrlService.deleteShortUrl(url);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ResponseEntity.ok("정상적으로 삭제되었습니다.");
    }
}
