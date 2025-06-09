package com.abp.ubea.mappers;

import com.abp.ubea.dtos.PartnerDTO;
import com.abp.ubea.entities.PartnerEntity;
import org.springframework.stereotype.Service;

@Service
public class PartnerMapper {

    public PartnerDTO convertEntityToDTO(PartnerEntity partner) {
        PartnerDTO dto = new PartnerDTO();
        dto.setId(partner.getId());
        dto.setName(partner.getName());
        dto.setDescription(partner.getDescription());
        dto.setAddress(partner.getAddress());
        dto.setPhone(partner.getPhone());
        return dto;
    }

    public PartnerEntity convertDTOToEntity(PartnerDTO dto) {
        PartnerEntity partner = new PartnerEntity();
        partner.setId(dto.getId());
        partner.setName(dto.getName());
        partner.setDescription(dto.getDescription());
        partner.setAddress(dto.getAddress());
        partner.setPhone(dto.getPhone());
        return partner;
    }
}
