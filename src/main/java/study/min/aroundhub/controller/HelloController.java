package study.min.aroundhub.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HelloController {

    private final Logger LOGGER = LoggerFactory.getLogger(HelloController.class);

    @RequestMapping("/hello")
    public String hello() {
        return "Hello World";
    }

    @PostMapping("log-test")
    public void logTest() {
        LOGGER.trace("trace Log");
        LOGGER.debug("debug Log");
        LOGGER.info("info Log");
        LOGGER.warn("warn Log");
        LOGGER.error("error Log");
    }

    @PostMapping("/exception")
    public void exceptionTest() throws Exception {
        float a = 0/0;
        throw new Exception();
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, String>> ExceptionHandler(Exception e) {
        HttpHeaders responseHeaders = new HttpHeaders();
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;

        LOGGER.info(e.getMessage());
        LOGGER.info(e.getLocalizedMessage());
        LOGGER.info("Controller 내 ExceptionHandler 호출");

        Map<String, String> map = new HashMap<>();
        map.put("error type", httpStatus.getReasonPhrase());
        map.put("error code", "400");
        map.put("message", "에러 발생: " + e.getMessage());

        return new ResponseEntity<>(map, responseHeaders, httpStatus);
    }
}
