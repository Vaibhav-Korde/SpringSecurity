package org.springsecurity.springsecurityexample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springsecurity.springsecurityexample.entities.User;
import org.springsecurity.springsecurityexample.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService service;


//    @GetMapping("/")
//    public String home() {
//        return "home";
//    }

    @GetMapping("/")
    public List<User> getAllUser() {
        List<User>list=service.getAllUser();
//		ModelAndView m=new ModelAndView();
//		m.setViewName("bookList");
//		m.addObject("book",list);
        return list;
    }

    @PostMapping("/save")
    public String addBook(@ModelAttribute User user) {
        service.save(user);
        return "THIS IS USER";
    }

}
