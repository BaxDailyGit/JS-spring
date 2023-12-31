package com.example.spring;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Service
public class ProductService {

    //private final ProductRepository productRepository ;

    private final ProductJpaRepository productJpaRepository ;
    public ProductService(ProductRepository productRepository, ProductJpaRepository productJpaRepository) {
        //this.productRepository = productRepository;
        this.productJpaRepository = productJpaRepository;
    }




    public List<ProductEntity> getProducts() {
        log.info("---------- Log : getProducts ---------");
        return productJpaRepository.findAll();

    }


    public Optional<ProductEntity> getProduct(long id) {

        Optional<ProductEntity> product = productJpaRepository.findById(id);

        if (product.isPresent()) {
            log.info("---------- Log : getProduct : api/product/{" + id + "} ----------");
            return product;
        } else {
            log.info("---------- Log : getProduct : api/product/{" + id + "}  ----------");
            return Optional.empty();
        }
    }

    public ProductEntity getProductByName(String name) {

        List<ProductEntity> product = productJpaRepository.findByName(name);
        if (!product.isEmpty()){
            return product.get(0);
        }
        else {
            return new ProductEntity("상품 준비중");
        }
    }

    public void saveProducts(ProductEntity product) {

        productJpaRepository.save(product);

    }


/*
    public Product getProduct(int index) {
        List <Product> products = productRepository.getProducts();
        if (index >= 0 && index < products.size()) {
            log.info("---------- Log : getProduct : api/product/{" + index + "} ----------");
            return productRepository.getProduct(index);
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


*/




}
