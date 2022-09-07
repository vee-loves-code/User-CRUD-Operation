package com.example.springbootdemo.serviceImpl;

import com.example.springbootdemo.model.User;
import com.example.springbootdemo.repository.UserRepository;
import com.example.springbootdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;


    @Override
    public Optional<User> findUserById(long userId) {
        Optional<User> returnedUser = userRepository.findById(userId);
        return returnedUser;
    }

    @Override
    public List<User> getAllUser() {
        List<User> allUsers = userRepository.findAll();
        return allUsers;
    }

    @Override
    public User addUser(User user) {
        User newUser = userRepository.save(user);
        return newUser;
    }

    @Override
    public User updateUser(long userId, User user) {
        User updatedUser = new User();
           if(findUserById(userId).isPresent()){
               updatedUser.setFirstName(user.getFirstName());
               updatedUser.setLastName(user.getLastName());
               updatedUser.setAddress(user.getAddress());
               updatedUser.setAge(user.getAge());
               userRepository.save(updatedUser);

           }else {
               System.out.println("user does not exist");
           }
        return updatedUser;
    }

    @Override
    public void deleteUser(long userId) {
        if(userRepository.existsById(userId)) {
            userRepository.deleteById(userId);
        }
    }
}
