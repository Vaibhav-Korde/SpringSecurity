package org.springsecurity.springsecurityexample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springsecurity.springsecurityexample.entities.User;
import org.springsecurity.springsecurityexample.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    // all user
    @GetMapping("/")
    public List<User> getAllUser(){
        return this.userService.getUserList();
    }

    // Single user

    @GetMapping("/{userName}")
    public User getUser( @PathVariable("userName") String userName){
         return this.userService.getUser(userName);
    }

    @PostMapping("/")
    public User add(@RequestBody User user){
        return this.userService.addUser(user);
    }
}
