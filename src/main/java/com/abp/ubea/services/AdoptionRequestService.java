package com.abp.ubea.services;

import com.abp.ubea.dtos.AdoptionRequestDTO;
import com.abp.ubea.entities.AdoptionRequestEntity;
import com.abp.ubea.exceptions.ResourceNotFoundException;
import com.abp.ubea.mappers.AdoptionRequestMapper;
import com.abp.ubea.repositories.AdoptionRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdoptionRequestService {

    @Autowired
    private AdoptionRequestRepository adoptionRequestRepository;

    @Autowired
    AdoptionRequestMapper adoptionRequestMapper;

    public List<AdoptionRequestDTO> findAll() {
        return adoptionRequestRepository.findAll()
                .stream()
                .map(adoptionRequestMapper::convertEntityToDTO)
                .collect(Collectors.toList());
    }

    public AdoptionRequestDTO findById(Integer id) {
        return adoptionRequestRepository.findById(id)
                .map(adoptionRequestMapper::convertEntityToDTO)
                .orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public AdoptionRequestDTO create(AdoptionRequestDTO dto){
        AdoptionRequestEntity adoptionRequest = adoptionRequestMapper.convertDTOToEntity(dto);
        return adoptionRequestMapper.convertEntityToDTO(adoptionRequestRepository.save(adoptionRequest));
    }

    public AdoptionRequestDTO update(AdoptionRequestDTO dto) {
        AdoptionRequestEntity adoptionRequest = adoptionRequestRepository.findById(dto.getId())
                .orElseThrow(() -> new ResourceNotFoundException(dto.getId()));

        adoptionRequest.setRequestDate(dto.getRequestDate());
        adoptionRequest.setStatus(dto.getStatus());
        adoptionRequest.setApprovalDate(dto.getApprovalDate());

        return adoptionRequestMapper.convertEntityToDTO(adoptionRequestRepository.save(adoptionRequest));
    }

    public void delete(Integer id) {
        if (!adoptionRequestRepository.existsById(id)) throw new ResourceNotFoundException(id);
        adoptionRequestRepository.deleteById(id);
    }
}
