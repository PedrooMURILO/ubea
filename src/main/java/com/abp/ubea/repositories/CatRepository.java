package com.abp.ubea.repositories;

import com.abp.ubea.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CatRepository extends JpaRepository<UserEntity, Integer> {}
