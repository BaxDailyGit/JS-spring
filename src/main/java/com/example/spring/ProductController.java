package com.example.spring;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import lombok.extern.slf4j.Slf4j;
@Slf4j
@RestController
public class ProductController {

    private final ProductService productService;
    public ProductController(ProductService productService) {
        this.productService = productService;
    }







    @GetMapping("api/products")
    public List<Product> getProducts() {
        return productService.getProducts();
    }





    @GetMapping("api/product/{index}")
    public Product getProduct(@PathVariable int index) {
        return productService.getProduct(index);
    }





    @PostMapping("/api/product")
    public String addProducts(@RequestBody Product product) {

        return productService.addProducts(product);
    }
}








