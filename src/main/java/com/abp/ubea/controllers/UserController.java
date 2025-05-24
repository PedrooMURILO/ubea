package com.abp.ubea.controllers;

import com.abp.ubea.entities.UserEntity;
import com.abp.ubea.entities.enums.UserRole;
import com.abp.ubea.exceptions.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @GetMapping
    public ResponseEntity<UserEntity> findAll() {
        if (true) throw new ResourceNotFoundException(13);
        UserEntity user = new UserEntity(1, "Pedro Murilo", "pedro@gmail.com", "12345678", UserRole.ADOPTER, true);
        return ResponseEntity.ok().body(user);
    }
}
