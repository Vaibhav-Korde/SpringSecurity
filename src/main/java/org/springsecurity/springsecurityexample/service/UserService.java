package org.springsecurity.springsecurityexample.service;

import org.springframework.stereotype.Service;
import org.springsecurity.springsecurityexample.entities.User;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    List<User> userList = new ArrayList<>();

    public UserService() {
        userList.add(new User("Aniket","Aniket123","aniket@gmail.com"));
        userList.add(new User("Vikas","Vikas123","vikas@gmail.com"));
    }

    //get all user
    public List<User> getUserList(){
        return this.userList;
    }

    //get sigle user
    public User getUser(String userName){
        return this.userList.stream().filter((user)-> user.getUserName()
                .equals(userName)).findAny().orElse(null);
    }

    //Add user
    public User addUser(User user){
        this.userList.add(user);
        return user;
    }
}
