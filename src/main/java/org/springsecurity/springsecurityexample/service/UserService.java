package org.springsecurity.springsecurityexample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springsecurity.springsecurityexample.entities.User;
import org.springsecurity.springsecurityexample.repository.UserRepository;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public String addUser(User user){
        user.setUserName("uttam");
        user.setPassword("uttam");
        user.setEmail("uttam@gmail.com");

        return "Done";
    }
    public void save(User user) {
        userRepository.save(user);
    }

    public List<User> getAllUser(){
        return userRepository.findAll();
    }


}
