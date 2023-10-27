package com.example.spring;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@Service
public class ProductService {
    private final ProductRepository productRepository;


    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    /*
    List<Product> products = new ArrayList<>(
            Arrays.asList(new Product("모니터", 100),
                    new Product("키보드", 200),
                    new Product("마우스", 300)
            ));

*/



    public List<Product> getProducts() {
        List <Product> products = productRepository.getProducts();

        log.info("---------- Log : getProducts ---------");
        return products;
    }




    public Product getProduct(@PathVariable int index) {
        List <Product> products = productRepository.getProducts();
        if (index >= 0 && index < products.size()) {
            log.info("---------- Log : getProduct : api/product/{" + index + "} ----------");
            return products.get(index);
        } else {
            log.info("---------- Log : getProduct : api/product/{" + index + "} // out of valid index----------");
            return new Product("상품 준비중", 0);
        }
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
