package com.example.SpringProject;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
public class Model {

    String username;
    String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Model(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
