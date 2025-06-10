package com.abp.ubea.mappers;

import com.abp.ubea.dtos.AdoptionRequestDTO;
import com.abp.ubea.entities.AdoptionRequestEntity;
import org.springframework.stereotype.Service;

@Service
public class AdoptionRequestMapper {

    public AdoptionRequestDTO convertEntityToDTO(AdoptionRequestEntity adoptionRequest) {
        AdoptionRequestDTO dto = new AdoptionRequestDTO();
        dto.setId(adoptionRequest.getId());
        dto.setRequestDate(adoptionRequest.getRequestDate());
        dto.setStatus(adoptionRequest.getStatus());
        dto.setApprovalDate(adoptionRequest.getApprovalDate());
        return dto;
    }

    public AdoptionRequestEntity convertDTOToEntity(AdoptionRequestDTO dto) {
        AdoptionRequestEntity adoptionRequest = new AdoptionRequestEntity();
        adoptionRequest.setId(dto.getId());
        adoptionRequest.setRequestDate(dto.getRequestDate());
        adoptionRequest.setStatus(dto.getStatus());
        adoptionRequest.setApprovalDate(dto.getApprovalDate());
        return adoptionRequest;
    }
}
