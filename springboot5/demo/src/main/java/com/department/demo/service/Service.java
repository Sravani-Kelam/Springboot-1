package com.department.demo.service;

import com.department.demo.dto.DepartmentDto;

public interface Service {
    DepartmentDto saveDepartment(DepartmentDto departmentDto);
    DepartmentDto getByid(int id);
    DepartmentDto updateDepartment(int id,DepartmentDto departmentDto);
}
