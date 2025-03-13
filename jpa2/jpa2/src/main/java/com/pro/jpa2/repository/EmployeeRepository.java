package com.pro.jpa2.repository;

,Employee,Integerpackage com.pro.jpa2 repository;

import com.pro.jpa2.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EmployeeRepository extends JpaRepository <Employee,Integer>{
}
