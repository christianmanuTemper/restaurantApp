package com.example.restuarant.repository;

import com.example.restuarant.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{

    @Query("SELECT u FROM Product u")
    List<Product> getAllProducts();
}
