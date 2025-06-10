package com.abp.ubea.mappers.min;

import com.abp.ubea.dtos.AdoptionRequestDTOMin;
import com.abp.ubea.entities.AdoptionRequestEntity;
import org.springframework.stereotype.Service;

@Service
public class AdoptionRequestMinMapper {

    public AdoptionRequestDTOMin convertEntityToDTOMin(AdoptionRequestEntity adoptionRequest) {
        AdoptionRequestDTOMin dto = new AdoptionRequestDTOMin();
        dto.setId(adoptionRequest.getId());
        dto.setRequestDate(adoptionRequest.getRequestDate());
        return dto;
    }

    public AdoptionRequestEntity convertDTOMinToEntity(AdoptionRequestDTOMin dto) {
        AdoptionRequestEntity adoptionRequest = new AdoptionRequestEntity();
        adoptionRequest.setId(dto.getId());
        return adoptionRequest;
    }
}
