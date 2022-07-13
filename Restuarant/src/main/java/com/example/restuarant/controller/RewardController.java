package com.example.restuarant.controller;


import com.example.restuarant.entity.Reward;
import com.example.restuarant.entity.User;
import com.example.restuarant.service.RewardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "/api/rewards")
public class RewardController {

    private final RewardService rewardService;

    @Autowired
    public RewardController(RewardService rewardService){
        this.rewardService = rewardService;
    }

    @GetMapping(path = "/all")
    public ResponseEntity<List<Reward>> findAllRewards(){
        List<Reward> rewards = rewardService.getAllRewards();
        return new ResponseEntity<>(rewards, HttpStatus.OK);
    }

    @PostMapping(path = "/save/newReward")
    public ResponseEntity<Reward> saveNewReward(@RequestBody Reward reward){
        Reward newReward = rewardService.saveNewReward(reward);
        return new ResponseEntity<>(newReward, HttpStatus.CREATED);
    }
}
