package com.department.demo.repository;

import com.department.demo.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DepartmentRepository extends JpaRepository<Department,Integer> {
    Optional<Department> findByid(int id);
}
