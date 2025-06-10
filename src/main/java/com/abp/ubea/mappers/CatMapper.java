package com.abp.ubea.mappers;

import com.abp.ubea.dtos.CatDTO;
import com.abp.ubea.entities.CatEntity;
import org.springframework.stereotype.Service;

@Service
public class CatMapper {

    public CatDTO convertEntityToDTO(CatEntity cat) {
        CatDTO dto = new CatDTO();
        dto.setId(cat.getId());
        dto.setName(cat.getName());
        dto.setSex(cat.getSex());
        dto.setAge(cat.getAge());
        dto.setDescription(cat.getDescription());
        dto.setAdopted(cat.getAdopted());
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
        return cat;
    }
}
