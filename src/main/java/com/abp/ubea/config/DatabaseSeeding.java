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
        UserEntity user1 = new UserEntity(null, "Pedro Murilo", "pedro@gmail.com", "12345678", UserRole.ADOPTER, true);
        UserEntity user2 = new UserEntity(null, "Alice", "alice@gmail.com", "12342378", UserRole.ADOPTER, false);
        UserEntity user3 = new UserEntity(null, "Bianca", "bianca@gmail.com", "2345678", UserRole.ADMIN, true);

        catRepository.saveAll(Arrays.asList(user1, user2, user3));
    }
}
