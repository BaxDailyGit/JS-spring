package com.example.spring;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Random;

@NoArgsConstructor
@Getter

public class Product {

    private Long id;

    private String name;

    private int price;


    public Product(String name, int price){
        this.name = name;
        this.price = price;

        Random random = new Random();
        this.id = Math.abs(random.nextLong() % 100L);

    }
}


