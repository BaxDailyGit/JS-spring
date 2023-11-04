package com.example.spring;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Repository // 1
public class ProductRepository {
    /*
    List<Product> products = new ArrayList<>(
            Arrays.asList(new Product("모니터", 100),
                    new Product("키보드", 200),
                    new Product("마우스", 300)
            ));
    //상품 전체 조회
    public List<ProductEntity> getProducts() {
        return products;
    }


    //상품 id로 상세 조회
    public ProductEntity getProduct(long id) {
        return products.get((int) id);
    }

    // 상품 등록
    public String addProducts(ProductEntity product) {
        products.add(product);
        return "성공";
    }

*/
}