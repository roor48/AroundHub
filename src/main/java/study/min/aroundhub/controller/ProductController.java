package study.min.aroundhub.controller;

import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import study.min.aroundhub.common.Constants;
import study.min.aroundhub.common.exception.AroundHubException;
import study.min.aroundhub.data.dto.ProductDto;
import study.min.aroundhub.service.ProductService;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/product-api") // http://locallhost:8080/api/v1/product-api/*
public class ProductController {

    private final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/product/{productId}")
    public ProductDto getProduct(@PathVariable("productId") String productId) {
        long startTime = System.currentTimeMillis();

        LOGGER.info("[ProductController] perform {} of Around Hub API.", "getProduct");

        ProductDto productDto = productService.getProduct(productId);
        LOGGER.info("[ProductController] Response :: productId = {}, productName = {}, productPrice = {}, productStock = {}, Response Time = {}ms",
                productDto.getProductId(), productDto.getProductName(), productDto.getProductPrice(), productDto.getProductStock(),
                System.currentTimeMillis() - startTime);

        return productDto;
    }

    @PostMapping("/product")
    public ResponseEntity<ProductDto> createProduct(@Valid @RequestBody ProductDto productDto) {
        String productId = productDto.getProductId();
        String productName = productDto.getProductName();
        int productPrice =  productDto.getProductPrice();
        int productStock = productDto.getProductStock();

        ProductDto response = productService.saveProduct(productId, productName, productPrice, productStock);

        LOGGER.info(
                "[createProduct] Response >> productId: {}, productName: {}, productPrice: {}, productStock: {}",
                response.getProductId(),
                response.getProductName(),
                response.getProductPrice(),
                response.getProductStock()
        );

        return ResponseEntity.ok().body(response);
    }

    @DeleteMapping("/product/{productId}")
    public ProductDto deleteProduct(@PathVariable("productId") String productId) {
        return null;
    }

    @PostMapping("/product/exception")
    public void exceptionTest() throws AroundHubException {
        throw new AroundHubException(
                Constants.ExceptionClass.PRODUCT,
                HttpStatus.FORBIDDEN,
                " 의도한 에러가 발생.");
    }
}
