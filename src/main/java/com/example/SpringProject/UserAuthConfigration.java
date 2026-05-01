package com.example.SpringProject;


import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


// here i have to import UserDetailService class jo mujhe help krege meri user ko authenticate krne ke liye login ke time pay
public class UserAuthConfigration implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}
