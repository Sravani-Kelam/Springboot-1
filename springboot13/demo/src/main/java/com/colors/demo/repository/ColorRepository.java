package com.colors.demo.repository;

import com.colors.demo.entity.ColorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ColorRepository extends JpaRepository<ColorEntity,Integer> {
    Optional<ColorEntity> findByid(int id);
}
