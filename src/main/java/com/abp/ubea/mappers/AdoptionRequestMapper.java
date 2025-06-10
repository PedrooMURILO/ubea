package com.abp.ubea.mappers;

import com.abp.ubea.dtos.AdoptionRequestDTO;
import com.abp.ubea.dtos.CatDTOMin;
import com.abp.ubea.entities.AdoptionRequestEntity;
import com.abp.ubea.entities.CatEntity;
import com.abp.ubea.mappers.min.CatMinMapper;
import com.abp.ubea.mappers.min.UserMinMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdoptionRequestMapper {

    @Autowired
    UserMinMapper userMapper;

    @Autowired
    CatMinMapper catMapper;

    public AdoptionRequestDTO convertEntityToDTO(AdoptionRequestEntity adoptionRequest) {
        AdoptionRequestDTO dto = new AdoptionRequestDTO();
        dto.setId(adoptionRequest.getId());
        dto.setRequestDate(adoptionRequest.getRequestDate());
        dto.setUser(userMapper.convertEntityToDTOMin(adoptionRequest.getUser()));

        List<CatDTOMin> cats = adoptionRequest.getCats()
                .stream()
                .map(catMapper::convertEntityToDTOMin)
                .toList();
        dto.setCats(cats);

        return dto;
    }

    public AdoptionRequestEntity convertDTOToEntity(AdoptionRequestDTO dto) {
        AdoptionRequestEntity adoptionRequest = new AdoptionRequestEntity();
        adoptionRequest.setId(dto.getId());
        adoptionRequest.setUser(userMapper.convertDTOMinToEntity(dto.getUser()));

        List<CatEntity> cats = dto.getCats()
                .stream()
                .map(catMapper::convertDTOMinToEntity)
                .toList();
        adoptionRequest.setCats(cats);

        return adoptionRequest;
    }
}
