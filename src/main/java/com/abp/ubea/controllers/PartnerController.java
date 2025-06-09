package com.abp.ubea.controllers;

import com.abp.ubea.dtos.PartnerDTO;
import com.abp.ubea.services.PartnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/partners")
public class PartnerController {

    @Autowired
    private PartnerService partnerService;

    @GetMapping
    public ResponseEntity<List<PartnerDTO>> findAll() {
        List<PartnerDTO> partners = partnerService.findAll();
        return ResponseEntity.ok().body(partners);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PartnerDTO> findById(@PathVariable Integer id) {
        PartnerDTO partner = partnerService.findById(id);
        return ResponseEntity.ok().body(partner);
    }

    @PostMapping
    public ResponseEntity<PartnerDTO> create(@RequestBody PartnerDTO dto) {
        dto = partnerService.create(dto);
        return ResponseEntity.ok().body(dto);
    }

    @PutMapping
    public ResponseEntity<PartnerDTO> update(@RequestBody PartnerDTO dto) {
        dto = partnerService.update(dto);
        return ResponseEntity.ok().body(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        partnerService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
