package com.stations.demo.repository;

import com.stations.demo.entity.StationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StationRepository extends JpaRepository<StationEntity,Integer> {
    Optional<StationEntity> findByid(int id);
}
