package com.example.SpringProject;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
public class Model {

    String userName;
    String password;

    public Model() {
    }

    public Model(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
