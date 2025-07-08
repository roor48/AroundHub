package study.min.aroundhub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import study.min.aroundhub.data.dto.ProductDto;
import study.min.aroundhub.service.ProductService;

@RestController
@RequestMapping("/api/v1/product-api") // http://locallhost:8080/api/v1/product-api/*
public class ProductController {
    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/product/{productId}")
    public ProductDto getProduct(@PathVariable("productId") String productId) {
        return productService.getProduct(productId);
    }

    @PostMapping("/product")
    public ProductDto createProduct(@RequestBody ProductDto productDto) {
        String productId = productDto.getProductId();
        String productName = productDto.getProductName();
        int productPrice =  productDto.getProductPrice();
        int productStock = productDto.getProductStock();

        return productService.saveProduct(productId, productName, productPrice, productStock);
    }

    @DeleteMapping("/product/{productId}")
    public ProductDto deleteProduct(@PathVariable("productId") String productId) {
        return null;
    }
}
