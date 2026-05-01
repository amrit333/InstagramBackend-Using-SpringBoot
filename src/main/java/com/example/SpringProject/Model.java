package com.example.SpringProject;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
public class Model {

    String userName;
    String password;


}
