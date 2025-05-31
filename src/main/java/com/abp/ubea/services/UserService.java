package com.abp.ubea.services;

import com.abp.ubea.dtos.UserDTO;
import com.abp.ubea.entities.UserEntity;
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

    public UserDTO create(UserDTO dto){
        UserEntity user = userMapper.convertDTOToEntity(dto);
        return userMapper.convertEntityToDTO(userRepository.save(user));
    }

    public UserDTO update(UserDTO dto) {
        UserEntity user = userRepository.findById(dto.getId())
                .orElseThrow(() -> new ResourceNotFoundException(dto.getId()));

        user.setUsername(dto.getUsername());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        user.setRole(dto.getRole());
        user.setEnabled(dto.getEnabled());
        user.setPhone(dto.getPhone());

        return userMapper.convertEntityToDTO(userRepository.save(user));
    }

    public void delete(Integer id) {
        if (!userRepository.existsById(id)) throw new ResourceNotFoundException(id);
        userRepository.deleteById(id);
    }
}
