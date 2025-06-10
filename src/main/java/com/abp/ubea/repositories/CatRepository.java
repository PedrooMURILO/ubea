package com.abp.ubea.repositories;

import com.abp.ubea.entities.CatEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CatRepository extends JpaRepository<CatEntity, Integer> {}
