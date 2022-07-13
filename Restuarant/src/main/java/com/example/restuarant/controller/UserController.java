package com.example.restuarant.controller;

import com.example.restuarant.entity.User;
import com.example.restuarant.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "/api/user")
public class UserController {

    private final UserService userService;


    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping(path = "/all")
    public ResponseEntity<List<User>> findAllUsers(){
        List<User> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PostMapping(path = "/save/newUser")
    public ResponseEntity<User> addNewUser(@RequestBody User user){
        User newUser = userService.saveNewUser(user);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

}
