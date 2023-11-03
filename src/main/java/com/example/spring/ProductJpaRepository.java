package com.example.spring;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductJpaRepository extends JpaRepository<Product, Long> {
    Optional<Product> findById(Long id);
    List<Product> findByName(String name);
    List<Product> findByPrice(int price);
}