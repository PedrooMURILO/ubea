package com.abp.ubea.services;

import com.abp.ubea.entities.UserEntity;
import com.abp.ubea.exceptions.ResourceNotFoundException;
import com.abp.ubea.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserEntity> findAll() {
        return userRepository.findAll();
    }

    public UserEntity findById(Integer id) {
        UserEntity user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));
        return user;
    }
}
