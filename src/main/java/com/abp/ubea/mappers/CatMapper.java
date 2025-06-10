package com.abp.ubea.mappers;

import com.abp.ubea.dtos.AdoptionRequestDTOMin;
import com.abp.ubea.dtos.CatDTO;
import com.abp.ubea.entities.AdoptionRequestEntity;
import com.abp.ubea.entities.CatEntity;
import com.abp.ubea.mappers.min.AdoptionRequestMinMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatMapper {

    @Autowired
    AdoptionRequestMinMapper adoptionRequestMapper;

    public CatDTO convertEntityToDTO(CatEntity cat) {
        CatDTO dto = new CatDTO();
        dto.setId(cat.getId());
        dto.setName(cat.getName());
        dto.setSex(cat.getSex());
        dto.setAge(cat.getAge());
        dto.setDescription(cat.getDescription());
        dto.setAdopted(cat.getAdopted());

        List<AdoptionRequestDTOMin> adoptionRequests = cat.getRequests()
                .stream()
                .map(adoptionRequestMapper::convertEntityToDTOMin)
                .toList();
        dto.setRequests(adoptionRequests);

        return dto;
    }

    public CatEntity convertDTOToEntity(CatDTO dto) {
        CatEntity cat = new CatEntity();
        cat.setId(dto.getId());
        cat.setName(dto.getName());
        cat.setSex(dto.getSex());
        cat.setAge(dto.getAge());
        cat.setDescription(dto.getDescription());
        cat.setAdopted(dto.getAdopted());

        List<AdoptionRequestEntity> adoptionRequests = dto.getRequests()
                .stream()
                .map(adoptionRequestMapper::convertDTOMinToEntity)
                .toList();
        cat.setRequests(adoptionRequests);

        return cat;
    }
}
