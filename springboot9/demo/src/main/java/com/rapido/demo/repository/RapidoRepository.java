package com.rapido.demo.repository;

import com.rapido.demo.entity.RapidoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RapidoRepository extends JpaRepository<RapidoEntity,Integer> {
    Optional<RapidoEntity> findByid(int id);
}
