package com.abp.ubea.mappers.min;

import com.abp.ubea.dtos.CatDTOMin;
import com.abp.ubea.entities.CatEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CatMinMapper {

    @Autowired
    AdoptionRequestMinMapper adoptionRequestMapper;

    public CatDTOMin convertEntityToDTOMin(CatEntity cat) {
        CatDTOMin dto = new CatDTOMin();
        dto.setId(cat.getId());
        dto.setName(cat.getName());
        dto.setSex(cat.getSex());
        dto.setAge(cat.getAge());
        dto.setDescription(cat.getDescription());
        dto.setAdopted(cat.getAdopted());
        return dto;
    }

    public CatEntity convertDTOMinToEntity(CatDTOMin dto) {
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
