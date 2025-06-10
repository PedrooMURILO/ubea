package com.abp.ubea.mappers;

import com.abp.ubea.dtos.AdoptionRequestDTO;
import com.abp.ubea.entities.AdoptionRequestEntity;
import com.abp.ubea.mappers.min.UserMinMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdoptionRequestMapper {

    @Autowired
    UserMinMapper userMapper;

    public AdoptionRequestDTO convertEntityToDTO(AdoptionRequestEntity adoptionRequest) {
        AdoptionRequestDTO dto = new AdoptionRequestDTO();
        dto.setId(adoptionRequest.getId());
        dto.setRequestDate(adoptionRequest.getRequestDate());
        dto.setUser(userMapper.convertEntityToDTOMin(adoptionRequest.getUser()));
        return dto;
    }

    public AdoptionRequestEntity convertDTOToEntity(AdoptionRequestDTO dto) {
        AdoptionRequestEntity adoptionRequest = new AdoptionRequestEntity();
        adoptionRequest.setId(dto.getId());
        adoptionRequest.setUser(userMapper.convertDTOMinToEntity(dto.getUser()));
        return adoptionRequest;
    }
}
