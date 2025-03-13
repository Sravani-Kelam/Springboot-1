package com.laptop.demo.repository;

import com.laptop.demo.entity.LapEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LapRepository extends JpaRepository<LapEntity,Integer> {
    Optional<LapEntity> findByid(int id);
}
