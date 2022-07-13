package com.example.restuarant.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "rewards")
public class Reward implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reward_id")
    private Integer rewardId;

    @Column(name = "reward")
    private String reward;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private Double price;

//    @Column(name = "picture")
//    private ImageIcon rewardPicture;

    @Column(name = "active")
    private Integer active;

    @OneToMany(mappedBy = "reward")
    private List<UserRewards> userRewards;

}
