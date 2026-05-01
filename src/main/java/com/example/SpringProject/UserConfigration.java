package com.example.SpringProject;

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
public class UserConfigration  {

    @Autowired
    UserAuthConfigration service;


    // this is my security filer chain functin where i will decide which endpoints of my API are secure and do not require authentication
//    for example in amazone i can Search for any element because it is not secure and don't require authetication but add to card, buy now these funciton does that's why
    @Bean
    public SecurityFilterChain configration(HttpSecurity http) throws Exception {
         return   http.csrf(csrf->csrf.disable())
                .authorizeHttpRequests(request-> request.requestMatchers("/user/**").permitAll().anyRequest().authenticated()).build();
    }






// this class is used to secure the user's data with spring security becuase earlier i have made the authentication not the security
//    same as i made sure he is the prime minister but i haven't give him the security so now i will provide this to him

    @Autowired
    public void userGloballyConfigration(AuthenticationManagerBuilder builder) throws Exception {

        // here i will call userDetailSerice Function To provide him the details of the user that i have autheticated
//        for example Detais of PM will go to RAW for his security along with Authorities of PM
        builder.userDetailsService(service).passwordEncoder(encoder());

    }
    @Bean
    public BCryptPasswordEncoder encoder(){
        return new BCryptPasswordEncoder();
    }
}
