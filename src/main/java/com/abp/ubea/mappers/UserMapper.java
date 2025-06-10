package com.abp.ubea.mappers;

import com.abp.ubea.dtos.AdoptionRequestDTOMin;
import com.abp.ubea.dtos.UserDTO;
import com.abp.ubea.entities.AdoptionRequestEntity;
import com.abp.ubea.entities.UserEntity;
import com.abp.ubea.mappers.min.AdoptionRequestMinMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserMapper {

    @Autowired
    AdoptionRequestMinMapper adoptionRequestMapper;

    public UserDTO convertEntityToDTO(UserEntity user) {
        UserDTO dto = new UserDTO();
        dto.setId(user.getId());
        dto.setUsername(user.getUsername());
        dto.setEmail(user.getEmail());
        dto.setPassword(user.getPassword());
        dto.setRole(user.getRole());
        dto.setEnabled(user.getEnabled());
        dto.setPhone(user.getPhone());

        List<AdoptionRequestDTOMin> adoptionRequests = user.getAdoptionRequests()
                .stream()
                .map(adoptionRequestMapper::convertEntityToDTOMin)
                .toList();
        dto.setAdoptionRequests(adoptionRequests);

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

        List<AdoptionRequestEntity> adoptionRequests = dto.getAdoptionRequests()
                .stream()
                .map(adoptionRequestMapper::convertDTOMinToEntity)
                .toList();
        user.setAdoptionRequests(adoptionRequests);

        return user;
    }
}
