package com.abp.ubea.controllers;

import com.abp.ubea.dtos.AdoptionRequestDTO;
import com.abp.ubea.services.AdoptionRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/requests")
public class AdoptionRequestController {

    @Autowired
    private AdoptionRequestService adoptionRequestService;

    @GetMapping
    public ResponseEntity<List<AdoptionRequestDTO>> findAll() {
        List<AdoptionRequestDTO> adoptionRequests = adoptionRequestService.findAll();
        return ResponseEntity.ok().body(adoptionRequests);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AdoptionRequestDTO> findById(@PathVariable Integer id) {
        AdoptionRequestDTO adoptionRequest = adoptionRequestService.findById(id);
        return ResponseEntity.ok().body(adoptionRequest);
    }

    @PostMapping
    public ResponseEntity<AdoptionRequestDTO> create(@RequestBody AdoptionRequestDTO dto) {
        dto = adoptionRequestService.create(dto);
        return ResponseEntity.ok().body(dto);
    }

    @PutMapping
    public ResponseEntity<AdoptionRequestDTO> update(@RequestBody AdoptionRequestDTO dto) {
        dto = adoptionRequestService.update(dto);
        return ResponseEntity.ok().body(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        adoptionRequestService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
