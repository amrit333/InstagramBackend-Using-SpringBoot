package com.example.SpringProject;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


// here i have to import UserDetailService class jo mujhe help krege meri user ko authenticate krne ke liye login ke time pay
public class UserAuthConfigration implements UserDetailsService {

    @Autowired
    Repo repo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Model user = repo.findByUserName(username);

        return User.builder().username(user.getUserName()).password(user.getPassword()).build();


    }
}
