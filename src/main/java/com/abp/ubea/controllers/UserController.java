package com.abp.ubea.controllers;

import com.abp.ubea.entities.UserEntity;
import com.abp.ubea.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<UserEntity>> findAll() {
        List<UserEntity> users = userService.findAll();
        return ResponseEntity.ok().body(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserEntity> findById(@PathVariable Integer id) {
        UserEntity user = userService.findById(id);
        return ResponseEntity.ok().body(user);
    }
}
