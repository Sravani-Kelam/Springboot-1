package com.pro.jpa6.conductor.repository;
import com.pro.jpa6.conductor.dto.ConductorDto;
import com.pro.jpa6.conductor.entity.Conductor;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ConductorRepository extends JpaRepository<Conductor,Integer> {

    Conductor findByphn(int phn);
    ConductorDto deleteByphn(int phn);
}
