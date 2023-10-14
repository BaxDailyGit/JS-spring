package com.example.spring;

import java.util.List;

public class Product {

    private String name;
    private int price;

    public Product(String name, int price){
        this.name = name;
        this.price = price;
    }


    public String getName(){
        return name;
    }
    public  int getPrice(){
        return price;
    }



    //중복인지 판별하는 메서드
    public static boolean isDuplicateProduct(String productName, List<Product> products) {
        for (Product existingProduct : products) {
            if (existingProduct.getName().equals(productName)) { //같은 상품 name이 있을때
                return true;
            }
        }
        return false;
    }
}
