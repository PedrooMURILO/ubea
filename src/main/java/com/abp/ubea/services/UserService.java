package com.abp.ubea.services;

import com.abp.ubea.dtos.UserDTO;
import com.abp.ubea.exceptions.ResourceNotFoundException;
import com.abp.ubea.mappers.UserMapper;
import com.abp.ubea.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    UserMapper userMapper;

    public List<UserDTO> findAll() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::convertEntityToDTO)
                .collect(Collectors.toList());
    }

    public UserDTO findById(Integer id) {
        return userRepository.findById(id)
                .map(userMapper::convertEntityToDTO)
                .orElseThrow(() -> new ResourceNotFoundException(id));
    }
}
