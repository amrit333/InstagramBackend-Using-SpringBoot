package com.example.SpringProject;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
@Configuration
@EnableWebSecurity
public class UserConfigration  {
    @Bean
    public SecurityFilterChain configration(HttpSecurity http) throws Exception {

      return   http.csrf(csrf->csrf.disable())
                .authorizeHttpRequests(request-> request.requestMatchers("/user/**").permitAll().anyRequest().authenticated()).build();
    }
}
