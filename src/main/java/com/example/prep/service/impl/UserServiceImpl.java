package com.example.prep.service.impl;


import com.example.prep.model.entity.UserEntity;
import com.example.prep.model.service.UserServiceModel;
import com.example.prep.repository.UserRepository;
import com.example.prep.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void register(UserServiceModel userServiceModel) {

        userRepository.save(
                modelMapper.map(userServiceModel , UserEntity.class));
    }

    @Override
    public UserServiceModel findByUsernameAndPassword(String username, String password) {
        return userRepository.findByUsernameAndPassword(username , password)
                .map(user -> modelMapper.map(user , UserServiceModel.class))
                .orElse(null);
    }
}
