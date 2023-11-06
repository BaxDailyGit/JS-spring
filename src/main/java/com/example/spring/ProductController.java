package com.example.spring;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


import lombok.extern.slf4j.Slf4j;
@Slf4j
@RestController
public class ProductController {

    private final ProductService productService;
    public ProductController(ProductService productService) {
        this.productService = productService;
    }







    @GetMapping("api/products")
    public List<ProductEntity> getProducts() {
        return productService.getProducts();
    }





    @GetMapping("api/product/{id}")
    public Optional<ProductEntity> getProduct(@PathVariable long id) {
        return productService.getProduct(id);
    }

    @GetMapping("api/product")
    public ProductEntity getProductByName(@RequestParam String name) {
        return productService.getProductByName(name);
    }


    @PostMapping("/api/product")
    public void addProducts(@RequestBody ProductEntity product) {

        productService.saveProducts(product);
    }


}








