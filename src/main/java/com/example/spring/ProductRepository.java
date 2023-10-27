package com.example.spring;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class ProductRepository {
    private final List<Product> products = new ArrayList<>(
            Arrays.asList(  new Product("모니터", 100),
                            new Product("키보드", 200),
                            new Product("마우스", 300)
    ));

    //상품 전체 조회
    public List<Product> getProducts() {
        return products;
    }

    //상품 id로 상세 조회
    public Product getProduct(int index) {
        return products.get(index);
    }

    // 상품 등록
    public String addProducts(Product product) {
        products.add(product);
        return "성공";
    }
}
