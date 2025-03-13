package com.hotel.demo.repository;

import com.hotel.demo.entity.HotelEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface HotelRepository extends JpaRepository<HotelEntity,Integer> {
    Optional<HotelEntity> findByid(int id);
}
