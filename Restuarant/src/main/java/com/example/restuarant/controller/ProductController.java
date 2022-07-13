package com.example.restuarant.controller;

import com.example.restuarant.entity.Product;
import com.example.restuarant.entity.User;
import com.example.restuarant.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "/api/products")
public class ProductController {

    private final ProductService productService;


    @Autowired
    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping(path = "/all")
    public ResponseEntity<List<Product>> findAllProducts(){
        List<Product> products = productService.getAllProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @PostMapping(path = "/save/newProduct")
    public ResponseEntity<Product> addNewProduct(@RequestBody Product product){
        Product newProduct = productService.saveNewProduct(product);
        return new ResponseEntity<>(newProduct, HttpStatus.CREATED);
    }
}
