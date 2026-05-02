package com.example.SpringProject.UserAuthentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


// here i will authenticate my user
public class UserService implements UserDetailsService {
    @Autowired
    UserRepo repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserModel user = repo.findByUserName(username);

        if(user!=null){
        return     User.builder().username(user.getUserName())
                    .password(user.getPassword())
                    .roles(user.getRoles())
                    .build();

        }
        else{
            return null;
        }


    }



}
