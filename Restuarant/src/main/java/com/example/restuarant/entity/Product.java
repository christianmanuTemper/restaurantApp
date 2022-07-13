package com.example.restuarant.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "products")
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Integer productId;

    @Column(name = "product")
    private String product;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private Double price;

    @Column(name = "date_added")
    private Timestamp dateAdded;

    @Column(name = "status")
    private Integer productStatus;

    @Column(name = "active")
    private Integer active;

    @Column(name = "quantity")
    private Integer quantity;

    @OneToMany(mappedBy = "product")
    private List<ProductsOrdered> productsOrdered;


}
