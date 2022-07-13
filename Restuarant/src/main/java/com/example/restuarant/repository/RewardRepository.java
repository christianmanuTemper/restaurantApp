package com.example.restuarant.repository;

import com.example.restuarant.entity.Reward;
import com.example.restuarant.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RewardRepository extends JpaRepository<Reward, Integer> {

    @Query("SELECT u FROM Reward u")
    List<Reward> findAllRewards();
}
