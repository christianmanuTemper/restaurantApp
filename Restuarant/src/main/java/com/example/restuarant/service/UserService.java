package com.example.restuarant.service;

import com.example.restuarant.entity.Role;
import com.example.restuarant.entity.User;
import com.example.restuarant.exceptions.NullException;
import com.example.restuarant.repository.RoleRepository;
import com.example.restuarant.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    private final RoleRepository roleRepository;

    @Autowired
    public UserService(UserRepository userRepository, RoleRepository roleRepository){
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User saveNewUser(User user){

        if(user.getUserFirstName() == null || user.getUserLastName() == null){
            throw new NullException("User id: " + user.getUserId() + " is missing a name please make sure both the first and last name is added.");
        }
        if(user.getUserEmailAddress() == null){
            throw new NullException("User id: " + user.getUserId() + " is missing an email address please add a valid email address and try again.");
        }
        if(user.getActiveUsers() == null){
            user.setActiveUsers(1);
        }
        if(user.getUserPhoneNumber() == null){
            throw new NullException("User id: " + user.getUserId() + " is missing a phone number please add a valid phone number and try again.");
        }
        if(user.getUserType() == null){
            throw new NullException("User id: " + user.getUserId() + " is missing a user type please add a user type and try again.");
        }else {
            if(user.getUserType().getUserType().equals("admin")){
                Role role = roleRepository.getReferenceById(1);
                user.setRole(role);
            }
            else if(user.getUserType().getUserType().equals("employee")){
                Role role = roleRepository.getReferenceById(2);
                user.setRole(role);
            }
            else{
                Role role = roleRepository.getReferenceById(3);
                user.setRole(role);
            }
        }
        user.setUserPassword(this.encodePassword(user.getUserPassword()));
        return userRepository.save(user);
    }

    /*  In App Service Methods */

    public String encodePassword(String password){
        String encodedPassword = Base64.getEncoder().encodeToString(password.getBytes());
        return encodedPassword;

    }

    public String decodePassword(String password){
        byte[] decodedBytes = Base64.getDecoder().decode(password);
        String decodedPassword = new String(decodedBytes);
        return decodedPassword;

    }

}
