package com.example.restuarant.service;

import com.example.restuarant.entity.Reward;
import com.example.restuarant.entity.User;
import com.example.restuarant.exceptions.NullException;
import com.example.restuarant.repository.RewardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class RewardService {

    private final RewardRepository rewardRepository;

    @Autowired
    public RewardService(RewardRepository rewardRepository){
        this.rewardRepository = rewardRepository;
    }

    public List<Reward> getAllRewards(){
        return rewardRepository.findAll();
    }

    public Reward saveNewReward(Reward reward){

        if(reward.getRewardId() == null){
            throw new NullException("This reward is missing an Id. Please add one and try again");
        }
        if(reward.getPrice() == null){
            throw new NullException("This reward is missing a price. Please add a price in points and try again");
        }
        if(reward.getActive() == null) {
            reward.setActive(1);
        }
        return rewardRepository.save(reward);
    }

    /* In app Methods */
    public Timestamp setTimeStamp(){
        Timestamp newTimestamp = new Timestamp(System.currentTimeMillis());
        return newTimestamp;
    }

}
