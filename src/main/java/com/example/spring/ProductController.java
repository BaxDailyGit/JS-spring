package com.example.spring;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class ProductController {

    List<Product> products = new ArrayList<>(
            Arrays.asList(new Product("모니터",100),
                    new Product("키보드",200),
                    new Product("마우스", 300)
            ));


    @GetMapping("api/products")
    public List<Product> getProducts() {
        return products;
    }




    @GetMapping("api/product/{index}")
    public Product getProduct(@PathVariable int index){
        if (index >= 0 && index < products.size()) {
            return products.get(index);
        } else {
            return new Product("상품 준비중", 0);
        }
    }





    @PostMapping("/api/product")
    public String addProducts(@RequestBody Product product){

        if (Product.isDuplicateProduct(product.getName(), products)) {
            return "실패";
        }
        else {
            products.add(product);
            return "성공";
        }
        /*
        for (Product p : products) {
            System.out.println("Product: " + p.getName() + ", Price: " + p.getPrice());
        }
        */
    }








}
