package com.example.restuarant.repository;


import com.example.restuarant.entity.UserType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserTypeRepository extends JpaRepository<UserType, Integer> {

    @Query("SELECT u FROM UserType u")
    List<UserType> findAllUserTypes();

}
