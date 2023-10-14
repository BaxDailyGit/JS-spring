package com.example.spring;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import lombok.extern.slf4j.Slf4j;
@Slf4j
@RestController
public class ProductController {

    List<Product> products = new ArrayList<>(
            Arrays.asList(new Product("모니터",100),
                    new Product("키보드",200),
                    new Product("마우스", 300)
            ));


    @GetMapping("api/products")
    public List<Product> getProducts() {
        log.info("---------- Log : getProducts ---------");
        return products;
    }




    @GetMapping("api/product/{index}")
    public Product getProduct(@PathVariable int index){
        if (index >= 0 && index < products.size()) {
            log.info("---------- Log : getProduct : api/product/{"+ index +"} ----------");
            return products.get(index);
        } else {
            log.info("---------- Log : getProduct : api/product/{"+ index +"} // out of valid index----------");
            return new Product("상품 준비중", 0);
        }
    }





    @PostMapping("/api/product")
    public String addProducts(@RequestBody Product product){
        if (Product.isDuplicateProduct(product.getName(), products)) {
            log.info("---------- Log : addProducts : " + product.getName() + " : 실패 ----------");
            return "실패";
        }
        else {
            products.add(product);
            log.info("---------- Log : addProducts : " + product.getName() + " : 성공 ----------");
            return "성공";
        }
    }








}
