package com.example.SpringProject.UserAuthentication;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class UserConfigration {

    @Autowired
    UserService service;
@Bean
    public SecurityFilterChain userSecurity(HttpSecurity http) throws Exception {
        return  http.csrf(csrf-> csrf.disable())
                .authorizeHttpRequests(request -> request
                        .requestMatchers("/admin").hasRole("ADMIN")
                        .requestMatchers("/auth").permitAll()
                        .anyRequest().authenticated())
                .build();

    }
//This is my Function to Secure my User as i have already autheticated him just like once the PM is nominated it's time to give him
//    The security
    @Autowired
    public void userGlobalConfigration(AuthenticationManagerBuilder managerBuilder) throws Exception {
    managerBuilder.userDetailsService(service).passwordEncoder(encoder());
    }

    @Bean
    public BCryptPasswordEncoder encoder(){
    return new BCryptPasswordEncoder();
    }

}
