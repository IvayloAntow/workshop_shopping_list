package com.example.prep.service;

import com.example.prep.model.service.UserServiceModel;

public interface UserService {
    void register(UserServiceModel userServiceModel);

    UserServiceModel findByUsernameAndPassword(String username, String password);
}
