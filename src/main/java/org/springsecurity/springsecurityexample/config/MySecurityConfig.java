package org.springsecurity.springsecurityexample.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class MySecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests((authorize) -> authorize
                        .requestMatchers("/home").permitAll()
                        .anyRequest().authenticated()
                )
                //.httpBasic(Customizer.withDefaults());
                .formLogin(form -> form.loginPage("/home")
                        .loginProcessingUrl("/dologin")
                        .usernameParameter("userName")
                        .passwordParameter("password")
                        .permitAll()
                        .defaultSuccessUrl("/user/")
                );


        return http.build();
    }

    @Bean
    public UserDetailsService users() {
        // The builder will ensure the passwords are encoded before saving in memory
        User.UserBuilder users = User.builder();
        UserDetails user = users
                .username("Aniket")
                .password(this.passwordEncoder().encode("aniket"))
                .roles("USER")
                .build();
        UserDetails admin = users
                .username("Vikas")
                .password(this.passwordEncoder().encode("vikas"))
                .roles("USER", "ADMIN")
                .build();
        return new InMemoryUserDetailsManager(user, admin);
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder(10);
    }
}
