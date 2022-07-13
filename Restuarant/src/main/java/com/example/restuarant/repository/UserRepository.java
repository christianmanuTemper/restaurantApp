package com.example.restuarant.repository;

import com.example.restuarant.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.swing.*;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    List<User> findAllByUserId(Integer userId);

    List<User> findUserByActiveUsers(Integer active);

    Optional<User> findUserByRequest(Integer requestId);

    Optional<User> findByUserId(Integer id);

    Optional<User> findUserByUserFirstName(String firstName);

    Optional<User> findUserByUserEmailAddress(String email);

    Optional<User> findUserByUserPhoneNumber(String pohoneNumber);

    Optional<User> findUserByUserLastName(String firstName);

    Optional<User> findUserByUserType(Integer userTypeId);

    Optional<User> findUserByRole(Integer email);


}
