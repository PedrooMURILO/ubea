package com.abp.ubea.mappers.min;

import com.abp.ubea.dtos.UserDTOMin;
import com.abp.ubea.entities.UserEntity;
import org.springframework.stereotype.Service;

@Service
public class UserMinMapper {

    public UserDTOMin convertEntityToDTOMin(UserEntity user) {
        UserDTOMin dto = new UserDTOMin();
        dto.setId(user.getId());
        dto.setUsername(user.getUsername());
        dto.setEmail(user.getEmail());
        dto.setPhone(user.getPhone());
        return dto;
    }

    public UserEntity convertDTOMinToEntity(UserDTOMin dto) {
        UserEntity user = new UserEntity();
        user.setId(dto.getId());
        user.setUsername(dto.getUsername());
        user.setEmail(dto.getEmail());
        user.setPhone(dto.getPhone());
        return user;
    }
}
