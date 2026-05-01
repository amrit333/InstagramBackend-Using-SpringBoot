package com.example.SpringProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class Controller {

    @Autowired
    Repo userRepo;
    @PostMapping()
    public String signup(@RequestBody Model user){
        userRepo.save(user);
        return "user saved succesfully";
    }
}
