package com.example.spring;

import lombok.Getter;

import javax.persistence.*;
import java.util.Random;

@Table
@Entity
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Getter
    @Column
    private String name;

    @Column
    private long price;

    public ProductEntity() {

    }


    public Long getId() {
        return id;
    }

    public Long getPrice() {
        return price;
    }
}