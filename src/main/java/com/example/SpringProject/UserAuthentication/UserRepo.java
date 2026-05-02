package com.example.SpringProject.UserAuthentication;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepo extends MongoRepository<UserModel,String> {

    public UserModel findByUserName(String userName);
}
