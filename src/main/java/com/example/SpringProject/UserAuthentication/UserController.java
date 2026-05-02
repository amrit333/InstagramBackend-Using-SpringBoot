package com.example.SpringProject.UserAuthentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class UserController  {

    @Autowired
    UserRepo repo;

    @PostMapping
    public ResponseEntity<String> signup(@RequestBody UserModel model){
            try{
                BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
                model.setPassword(encoder.encode(model.getPassword()));
                repo.save(model);
                return new ResponseEntity<>("user created succesfully",HttpStatus.CREATED);


            }catch (Exception e){
                return  new ResponseEntity<>("an error occured",HttpStatus.BAD_REQUEST);
            }
    }

}
