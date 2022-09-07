package com.example.springbootdemo.controller;

import com.example.springbootdemo.model.User;
import com.example.springbootdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController{
    @Autowired
    UserService userService;

    @GetMapping("/details/{userId}")
    public Optional<User> findUser(@PathVariable long userId){
       Optional<User> user = userService.findUserById(userId);
       return user;
    }

    @GetMapping("/all-user")
    public List<User> getAllUser(){
        List<User> returnUser =  userService.getAllUser();
        return returnUser;
    }

    @PostMapping("/add-user")
    public User addUser(@RequestBody User user) {
        User newUser = userService.addUser(user);
        return newUser;
    }

    @PutMapping("/edit/{userId}")
    public User updateUser(@PathVariable long userId, @RequestBody User user) {
        System.out.println("controller 1");

        User updatedUser = userService.updateUser(userId, user);
        System.out.println("controller 2");
        return updatedUser;
    }

    @DeleteMapping("/delete-user/{userId}")
    public void deleteUser(@PathVariable long userId) {
        userService.deleteUser(userId);
    }
}
