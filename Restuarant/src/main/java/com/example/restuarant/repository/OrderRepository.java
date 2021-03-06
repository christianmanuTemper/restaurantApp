package com.example.restuarant.repository;

import com.example.restuarant.entity.Order;
import com.example.restuarant.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
    @Query("SELECT u FROM Order u")
    List<Order> findAllOrders();
}
