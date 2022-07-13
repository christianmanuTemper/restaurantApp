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
@Table(name = "orders")
public class Order implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Integer orderId;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    @Column(name = "order_date")
    private Timestamp orderDate;

    @Column(name = "last_update")
    private Timestamp lastUpdate;

    @Column(name = "delivery_type")
    private String deliveryType;

    @Column(name = "active")
    private Integer active;

    @Column(name = "order_status")
    private String orderStatus;


    @OneToMany(mappedBy = "order")
    private List<ProductsOrdered> productsOrdered;
}
