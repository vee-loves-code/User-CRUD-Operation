package com.example.springbootdemo.service;

import com.example.springbootdemo.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    Optional<User> findUserById(long userId);
    List<User> getAllUser();
    User addUser(User user);
    User updateUser(long userId, User user);
    void deleteUser(long userId);
}
