package com.example.restuarant.controller;


import com.example.restuarant.entity.Order;
import com.example.restuarant.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "/api/orders")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService){
        this.orderService = orderService;
    }

    @GetMapping(path = "/all")
    public ResponseEntity<List<Order>> findAllOrders(){
        List<Order> orders = orderService.getAllOrders();
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @PostMapping(path = "/save/newOrder")
    public ResponseEntity<Order> addNewOrder(@RequestBody Order order){
        Order newOrder = orderService.saveNewOrder(order);
        return new ResponseEntity<>(newOrder, HttpStatus.CREATED);
    }

}
