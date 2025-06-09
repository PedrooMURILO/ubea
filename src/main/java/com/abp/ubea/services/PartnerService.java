package com.abp.ubea.services;

import com.abp.ubea.dtos.PartnerDTO;
import com.abp.ubea.entities.PartnerEntity;
import com.abp.ubea.exceptions.ResourceNotFoundException;
import com.abp.ubea.mappers.PartnerMapper;
import com.abp.ubea.repositories.PartnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PartnerService {

    @Autowired
    private PartnerRepository partnerRepository;

    @Autowired
    PartnerMapper partnerMapper;

    public List<PartnerDTO> findAll() {
        return partnerRepository.findAll()
                .stream()
                .map(partnerMapper::convertEntityToDTO)
                .collect(Collectors.toList());
    }

    public PartnerDTO findById(Integer id) {
        return partnerRepository.findById(id)
                .map(partnerMapper::convertEntityToDTO)
                .orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public PartnerDTO create(PartnerDTO dto){
        PartnerEntity partner = partnerMapper.convertDTOToEntity(dto);
        return partnerMapper.convertEntityToDTO(partnerRepository.save(partner));
    }

    public PartnerDTO update(PartnerDTO dto) {
        PartnerEntity partner = partnerRepository.findById(dto.getId())
                .orElseThrow(() -> new ResourceNotFoundException(dto.getId()));

        partner.setName(dto.getName());
        partner.setDescription(dto.getDescription());
        partner.setAddress(dto.getAddress());
        partner.setPhone(dto.getPhone());

        return partnerMapper.convertEntityToDTO(partnerRepository.save(partner));
    }

    public void delete(Integer id) {
        if (!partnerRepository.existsById(id)) throw new ResourceNotFoundException(id);
        partnerRepository.deleteById(id);
    }
}
