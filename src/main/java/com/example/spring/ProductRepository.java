package com.example.spring;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class ProductRepository {
    private final List<Product> products = new ArrayList<>();

    //상품 전체 조회
    public List<Product> getProducts() {
        return products;
    }

    //상품 id로 상세 조회


    // 상품 등록
    public String addProducts(Product product) {
        products.add(product);
        return "성공";
    }
}
