package com.example.coffeshop.service;

import com.example.coffeshop.model.entity.User;
import com.example.coffeshop.model.service.UserServiceModel;
import com.example.coffeshop.model.view.UserViewModel;

import java.util.List;

public interface UserService {
    UserServiceModel registerUser(UserServiceModel map);

    UserServiceModel findByUsernameAndPassword(String username, String password);

    void loginUser(Long id, String username);

    User findById(Long id);

    List<UserViewModel> findAllUserAndCountOfOrdersOrderByCountDesc();
}
