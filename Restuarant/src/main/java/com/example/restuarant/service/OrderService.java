package com.example.restuarant.service;

import com.example.restuarant.entity.Order;
import com.example.restuarant.entity.User;
import com.example.restuarant.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository){
        this.orderRepository = orderRepository;
    }

    public List<Order> getAllOrders(){
        return this.orderRepository.findAllOrders();
    }

    public Order saveNewOrder(Order order){
        if(order.getOrderDate() == null){
            order.setOrderDate(setTimeStamp());
        }

        if(order.getLastUpdate() == null){
            order.setLastUpdate(setTimeStamp());
        }

        if(order.getActive() == null){
            order.setActive(1);
        }

        if(order.getOrderStatus() == null){
            order.setOrderStatus("Order Received");
        }

        return orderRepository.save(order);
    }

    /* In App Methods */

    public Timestamp setTimeStamp(){
        Timestamp newTimestamp = new Timestamp(System.currentTimeMillis());
        return newTimestamp;
    }

}
