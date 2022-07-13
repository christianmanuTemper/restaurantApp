package com.example.restuarant.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import javax.persistence.Entity;
import java.io.Serializable;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")

public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", insertable = false, updatable = false)
    private Integer userId;

    @Column(name = "first_name")
    private String userFirstName;

    @Column(name = "last_name")
    private String userLastName;

    @Column(name = "email")
    private String userEmailAddress;

    @Column(name = "password")
    private String userPassword;

    @Column(name = "phone_numebr")
    private String userPhoneNumber;

//    @Column(name = "profile_picture")
//    private ImageIcon userPicture;

    @Column(name = "total_reward_points")
    private Integer userRewardPoints;

    @Column(name = "active")
    private Integer activeUsers;

    @ManyToOne
    @JoinColumn(name="user_type_id")
    private UserType userType;

    @ManyToOne
    @JoinColumn(name="role_id")
    private Role role;

    @OneToMany(mappedBy = "user")
    private List<Order> orders;

    @OneToOne
    @JoinColumn(name = "request_id")
    private Request request;

    @OneToMany(mappedBy = "user")
    private List<Reservation> reservations;

    @OneToMany(mappedBy = "user")
    private List<UserRewards> userRewardsList;


}
