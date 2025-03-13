package com.astrology.demo.repository;

import com.astrology.demo.entity.AstroEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AstroRepository extends JpaRepository<AstroEntity,Integer> {
    Optional<AstroEntity> findByid(int id);
}
