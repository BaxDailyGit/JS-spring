package com.example.spring;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Getter
public class Product {

    private String name;
    private int price;


    public Product(String name, int price){
        this.name = name;
        this.price = price;
    }


}


