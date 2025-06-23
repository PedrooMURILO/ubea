package com.abp.ubea.controllers;

import com.abp.ubea.dtos.LoginRequestDTO;
import com.abp.ubea.entities.UserEntity;
import com.abp.ubea.mappers.UserMapper;
import com.abp.ubea.mappers.min.UserMinMapper;
import com.abp.ubea.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    UserMinMapper userMinMapper;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequestDTO loginRequest) {
        UserEntity userEntity = userRepository.findByEmailAndPassword(
                loginRequest.getEmail(), loginRequest.getPassword())
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.UNAUTHORIZED, "Invalid email or password."
                ));
        return ResponseEntity.ok(userMinMapper.convertEntityToDTOMin(userEntity));
    }
}
