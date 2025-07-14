package study.min.aroundhub.service.impl;

import java.net.URI;
import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import study.min.aroundhub.data.dao.ShortUrlDao;
import study.min.aroundhub.data.dto.MinUriDto;
import study.min.aroundhub.data.dto.ShortUrlResponseDto;
import study.min.aroundhub.data.entity.ShortUrlEntity;
import study.min.aroundhub.service.ShortUrlService;

@Service
public class ShortUrlServiceImpl implements ShortUrlService {

    Logger LOGGER = LoggerFactory.getLogger(ShortUrlServiceImpl.class);

    ShortUrlDao shortUrlDao;

    @Autowired
    public ShortUrlServiceImpl(ShortUrlDao shortUrlDao) {
        this.shortUrlDao = shortUrlDao;
    }

    @Override
    public ShortUrlResponseDto getShortUrl(String clientId, String clientSecret, String originalUrl) {

        LOGGER.info("[getShortUrl] request data : {}", originalUrl);
        ShortUrlEntity getShortUrlEntity = shortUrlDao.getShortUrl(originalUrl);

        String orgUrl;
        String shortUrl;

        if (getShortUrlEntity == null) {
            LOGGER.info("[getShortUrl] No Entity in Database.");
            ResponseEntity<MinUriDto> responseEntity = requestShortUrl(clientId, clientSecret, originalUrl);

            orgUrl = responseEntity.getBody().getResult().getOrigin();
            shortUrl = responseEntity.getBody().getResult().getUrl();

        } else {
            orgUrl = getShortUrlEntity.getOrgUrl();
            shortUrl = getShortUrlEntity.getUrl();
        }

        ShortUrlResponseDto shortUrlResponseDto = new ShortUrlResponseDto(orgUrl, shortUrl);

        LOGGER.info("[getShortUrl] Response DTO : {}", shortUrlResponseDto);
        return shortUrlResponseDto;
    }

    @Override
    public ShortUrlResponseDto generateShortUrl(String clientId, String clientSecret, String originalUrl) {
        LOGGER.info("[generateShortUrl] request data : {}", originalUrl);

        ResponseEntity<MinUriDto> responseEntity = requestShortUrl(clientId, clientSecret, originalUrl);

        LOGGER.info("[generateShortUrl] response : {}", responseEntity.getBody().getResult());

        String orgUrl = responseEntity.getBody().getResult().getOrigin();
        String shortUrl = responseEntity.getBody().getResult().getUrl();
        String hash = responseEntity.getBody().getResult().getHash();

        ShortUrlEntity shortUrlEntity = new ShortUrlEntity();
        shortUrlEntity.setOrgUrl(orgUrl);
        shortUrlEntity.setUrl(shortUrl);
        shortUrlEntity.setHash(hash);

        shortUrlDao.saveShortUrl(shortUrlEntity);

        ShortUrlResponseDto shortUrlResponseDto = new ShortUrlResponseDto(orgUrl, shortUrl);
        LOGGER.info("[generateShortUrl] Response DTO : {}", shortUrlResponseDto.toString());
        return shortUrlResponseDto;
    }

    @Override
    public ShortUrlResponseDto updateShortUrl(String clientId, String clientSecret,
        String originalUrl) {
        return null;
    }

    @Override
    public ShortUrlResponseDto deleteByShortUrl(String shortUrl) {
        return null;
    }

    @Override
    public ShortUrlResponseDto deleteByOriginalUrl(String originalUrl) {
        return null;
    }

    private ResponseEntity<MinUriDto> requestShortUrl(String clientId, String clientSecret, String originalUrl) {
        LOGGER.info("[requestShortUrl] client ID : ***, client Secret : ***, origin URL : {}", originalUrl);

        URI uri = UriComponentsBuilder
            .fromUriString("http://localhost:7070")
            .path("/v1/util/shorturl")
            .queryParam("origin", originalUrl)
            .build().toUri();

        LOGGER.info("[requestShortUrl] set HTTP Request Header");
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(new MediaType[]{MediaType.APPLICATION_JSON}));
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("X-Min-Client-Id", clientId);
        headers.set("X-Min-Client-Secret", clientSecret);

        HttpEntity<String> entity = new HttpEntity<>("", headers);

        RestTemplate restTemplate = new RestTemplate();

        LOGGER.info("[requestShortUrl] request by restTemplate Uri : {}", uri);
        ResponseEntity<MinUriDto> responseEntity = restTemplate.exchange(uri, HttpMethod.POST, entity, MinUriDto.class);

        LOGGER.info("[requestShortUrl] request has been successfully completed");

        return responseEntity;
    }
}
