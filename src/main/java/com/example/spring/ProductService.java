package com.example.spring;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@Service
public class ProductService {
    private final ProductRepository productRepository;


    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    public String addProducts(Product product) {

        List <Product> products = productRepository.getProducts();

        for (Product existingProduct : products) {
            if (existingProduct.getName().equals(product.getName())) { //같은 상품 name이 있을때
                log.info("---------- Log : addProducts : " + product.getName() + " : 실패 ----------");
                return "실패";
            }
        }
        productRepository.addProducts(product);
        log.info("---------- Log : addProducts : " + product.getName() + " : 성공 ----------");
        return "성공";
    }







}
