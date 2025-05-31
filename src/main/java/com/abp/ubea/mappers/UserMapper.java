package com.abp.ubea.mappers;

import com.abp.ubea.dtos.UserDTO;
import com.abp.ubea.entities.UserEntity;
import org.springframework.stereotype.Service;

@Service
public class UserMapper {

    public UserDTO convertEntityToDTO(UserEntity user) {
        UserDTO dto = new UserDTO();
        dto.setId(user.getId());
        dto.setUsername(user.getUsername());
        dto.setEmail(user.getEmail());
        dto.setPassword(user.getPassword());
        dto.setRole(user.getRole());
        dto.setEnabled(user.getEnabled());
        dto.setPhone(user.getPhone());
        return dto;
    }

    public UserEntity convertDTOToEntity(UserDTO dto) {
        UserEntity user = new UserEntity();
        user.setId(dto.getId());
        user.setUsername(dto.getUsername());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        user.setRole(dto.getRole());
        user.setEnabled(dto.getEnabled());
        user.setPhone(dto.getPhone());
        return user;
    }
}
