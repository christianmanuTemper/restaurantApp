package com.example.restuarant.repository;


import com.example.restuarant.entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StatusRepository extends JpaRepository<Status, Integer> {

    @Query("SELECT u FROM Status u")
    List<Status> findAllStatus();
}
