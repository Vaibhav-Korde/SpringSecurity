package org.springsecurity.springsecurityexample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springsecurity.springsecurityexample.entities.User;
import org.springsecurity.springsecurityexample.repository.UserRepository;

public class CustomUserDetails implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = this.userRepository.getById(username);
        if(user == null){
            throw new UsernameNotFoundException("USER NOT FOUND");

        }
        return new CostomeUserDetailsService(user);
    }
}
