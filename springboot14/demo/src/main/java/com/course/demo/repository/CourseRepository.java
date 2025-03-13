package com.course.demo.repository;

import com.course.demo.entity.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CourseRepository extends JpaRepository<CourseEntity,Integer> {
    Optional<CourseEntity> findByid(int id);


}
