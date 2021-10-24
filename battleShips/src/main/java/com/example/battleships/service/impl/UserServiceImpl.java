package com.example.battleships.service.impl;

import com.example.battleships.model.entity.User;
import com.example.battleships.model.service.UserServiceModel;
import com.example.battleships.repository.UserRepository;
import com.example.battleships.sec.CurrentUser;
import com.example.battleships.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final ModelMapper modelMapper;
    private final UserRepository userRepository;
    private final CurrentUser currentUser;

    public UserServiceImpl(ModelMapper modelMapper, UserRepository userRepository, CurrentUser currentUser) {
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
        this.currentUser = currentUser;
    }


    @Override
    public UserServiceModel registerUser(UserServiceModel userServiceModel) {

        User user = modelMapper.map(userServiceModel,User.class);
        return modelMapper.map(userRepository.save(user),UserServiceModel.class);
    }

    @Override
    public UserServiceModel findByUsernameAndPassword(String username, String password) {
        return userRepository
                .findByUsernameAndPassword(username,password)
                .map(user -> modelMapper.map(user, UserServiceModel.class))
                .orElse(null);
    }

    @Override
    public void loginUser(Long id, String username) {
        currentUser
                .setId(id);
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }
}
