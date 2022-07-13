package com.example.restuarant.repository;

import com.example.restuarant.entity.Request;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RequestRepository extends JpaRepository<Request, Integer> {

    @Query("SELECT u FROM Request u")
    List<Request> findAllRequests();
}
