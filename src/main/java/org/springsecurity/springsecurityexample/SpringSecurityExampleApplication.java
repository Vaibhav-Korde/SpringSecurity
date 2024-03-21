package org.springsecurity.springsecurityexample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springsecurity.springsecurityexample.entities.User;
import org.springsecurity.springsecurityexample.repository.UserRepository;

@SpringBootApplication
public class SpringSecurityExampleApplication implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityExampleApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        User user = new User();
        user.setUserName("Uttam");
        user.setPassword(this.bCryptPasswordEncoder.encode("uttam"));
        user.setEmail("uttam@gmail.com");
        user.setRole("ADMIN");
        this.userRepository.save(user);

        User user2 = new User();
        user2.setUserName("Mahesh");
        user2.setPassword(this.bCryptPasswordEncoder.encode("mahesh"));
        user2.setEmail("mahesh@gmail.com");
        user2.setRole("NORMAL");
        this.userRepository.save(user2);
    }
}
