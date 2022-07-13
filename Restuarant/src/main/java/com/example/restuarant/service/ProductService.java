package com.example.restuarant.service;

import com.example.restuarant.entity.Product;
import com.example.restuarant.exceptions.NullException;
import com.example.restuarant.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public Product saveNewProduct(Product product){

        if(product.getDateAdded() == null){
            product.setDateAdded(setTimeStamp());
        }

        if(product.getActive() == null){
            product.setActive(1);
        }

        if(product.getProductStatus() == null){
            product.setProductStatus(1);
        }

        if(product.getPrice() == null || product.getPrice() < 0){
            throw new NullException(product.getProduct()+" does not have a price. Please add a dollar amount and resubmit.");
        }

        if(product.getQuantity() == null || product.getQuantity() < 0){
            throw new NullException(product.getProduct()+" does not have a set quantity for inventory. Please add an amount and try again.");
        }

        return productRepository.save(product);
    }

    /* In app Methods */
    public Timestamp setTimeStamp(){
        Timestamp newTimestamp = new Timestamp(System.currentTimeMillis());
        return newTimestamp;
    }
}
