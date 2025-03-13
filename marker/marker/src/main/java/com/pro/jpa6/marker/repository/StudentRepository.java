package com.pro.jpa6.marker.repository;
import com.pro.jpa6.marker.dto.StudentDto;
import com.pro.jpa6.marker.entity.Students;
import org.springframework.data.jpa.repository.JpaRepository;


public interface StudentRepository extends JpaRepository<Students,Integer> {

    Students findByid(int id);
    StudentDto deleteByid(int id);
}
