package com.abp.ubea.controllers;

import com.abp.ubea.dtos.CatDTO;
import com.abp.ubea.services.CatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/cats")
public class CatController {

    @Autowired
    private CatService catService;

    @GetMapping
    public ResponseEntity<List<CatDTO>> findAll() {
        List<CatDTO> cats = catService.findAll();
        return ResponseEntity.ok().body(cats);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CatDTO> findById(@PathVariable Integer id) {
        CatDTO cat = catService.findById(id);
        return ResponseEntity.ok().body(cat);
    }

    @PostMapping
    public ResponseEntity<CatDTO> create(@RequestBody CatDTO dto) {
        dto = catService.create(dto);
        return ResponseEntity.ok().body(dto);
    }

    @PutMapping
    public ResponseEntity<CatDTO> update(@RequestBody CatDTO dto) {
        dto = catService.update(dto);
        return ResponseEntity.ok().body(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        catService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
