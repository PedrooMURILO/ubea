package com.abp.ubea.config;

import com.abp.ubea.entities.UserEntity;
import com.abp.ubea.entities.enums.UserRole;
import com.abp.ubea.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class DatabaseSeeding implements CommandLineRunner {

    @Autowired
    private UserRepository catRepository;

    @Override
    public void run(String... args) throws Exception {
        UserEntity user1 = new UserEntity(null, "Pedro Murilo", "pedro@gmail.com", "12345678", UserRole.ADOPTER, true, "1799999999");
        UserEntity user2 = new UserEntity(null, "Alice", "alice@gmail.com", "12342378", UserRole.ADOPTER, false, "1792399999");
        UserEntity user3 = new UserEntity(null, "Bianca", "bianca@gmail.com", "2345678", UserRole.ADMIN, true, "179995799");

        catRepository.saveAll(Arrays.asList(user1, user2, user3));
    }
}
