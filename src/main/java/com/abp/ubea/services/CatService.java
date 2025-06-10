package com.abp.ubea.services;

import com.abp.ubea.dtos.CatDTO;
import com.abp.ubea.entities.CatEntity;
import com.abp.ubea.exceptions.ResourceNotFoundException;
import com.abp.ubea.mappers.CatMapper;
import com.abp.ubea.repositories.CatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CatService {

    @Autowired
    private CatRepository catRepository;

    @Autowired
    CatMapper catMapper;

    public List<CatDTO> findAll() {
        return catRepository.findAll()
                .stream()
                .map(catMapper::convertEntityToDTO)
                .collect(Collectors.toList());
    }

    public CatDTO findById(Integer id) {
        return catRepository.findById(id)
                .map(catMapper::convertEntityToDTO)
                .orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public CatDTO create(CatDTO dto){
        CatEntity cat = catMapper.convertDTOToEntity(dto);
        return catMapper.convertEntityToDTO(catRepository.save(cat));
    }

    public CatDTO update(CatDTO dto) {
        CatEntity cat = catRepository.findById(dto.getId())
                .orElseThrow(() -> new ResourceNotFoundException(dto.getId()));

        cat.setName(dto.getName());
        cat.setSex(dto.getSex());
        cat.setAge(dto.getAge());
        cat.setDescription(dto.getDescription());
        cat.setAdopted(dto.getAdopted());

        return catMapper.convertEntityToDTO(catRepository.save(cat));
    }

    public void delete(Integer id) {
        if (!catRepository.existsById(id)) throw new ResourceNotFoundException(id);
        catRepository.deleteById(id);
    }
}
