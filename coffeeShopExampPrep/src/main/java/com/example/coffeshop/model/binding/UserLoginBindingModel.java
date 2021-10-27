package com.example.coffeshop.model.binding;

import javax.validation.constraints.Size;

public class UserLoginBindingModel {

    @Size(min = 5, max = 20,message = "Username must from 5 to 20 symbols.")
    private String username;
    @Size(min = 3 , message = "password must min 3 symbols")
    private String password;

    public UserLoginBindingModel() {
    }

    public String getUsername() {
        return username;
    }

    public UserLoginBindingModel setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserLoginBindingModel setPassword(String password) {
        this.password = password;
        return this;
    }
}
