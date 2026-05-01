package com.example.SpringProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class Controller {

    @Autowired
    Repo userRepo;
    @PostMapping()
    public String signup(@RequestBody Model user){

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(user.getPassword()));
        userRepo.save(user);
        return "user saved succesfully";
    }
    @GetMapping("/{username}")
    public Model get(@PathVariable String username){
        Model model = userRepo.findByUserName(username);
        return model;
    }
}
