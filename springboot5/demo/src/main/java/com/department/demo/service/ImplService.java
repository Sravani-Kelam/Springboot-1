package com.department.demo.service;

import com.department.demo.dto.DepartmentDto;
import com.department.demo.entity.Department;
import com.department.demo.repository.DepartmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ImplService {
    @Autowired
    private DepartmentRepository departmentrepo;


    public DepartmentDto saveDepartment(DepartmentDto departmentDto){
           Department department=new Department(
                   departmentDto.getId(),
                   departmentDto.getName(),
                   departmentDto.getDepartments(),
                   departmentDto.getMarks()
           );
           Department saveDepartment=departmentrepo.save(department);
           DepartmentDto savedepartmentDto=new DepartmentDto(
                   saveDepartment.getId(),
                   saveDepartment.getName(),
                   saveDepartment.getDepartments(),
                   saveDepartment.getMarks()
           );
           return savedepartmentDto;
       }
       public DepartmentDto getByid(int id){
        Department department=departmentrepo.findByid(id)
                .orElseThrow(()->new RuntimeException("department not found"));
        return new DepartmentDto(
                department.getId(),
                department.getName(),
                department.getDepartments(),
                department.getMarks()
        );
       }
       public DepartmentDto updateDepartment(int id, DepartmentDto departmentDto){
        Department existingDepartment=departmentrepo.findByid(id)
                .orElseThrow(()->new RuntimeException("department is not found by id:"+id));

        existingDepartment.setDepartments(departmentDto.getDepartments());
        existingDepartment.setName(departmentDto.getName());
        existingDepartment.setMarks(departmentDto.getMarks());

        Department updatedDepartment=departmentrepo.save(existingDepartment);
        return new DepartmentDto(
                updatedDepartment.getId(),
                updatedDepartment.getName(),
                updatedDepartment.getDepartments(),
                updatedDepartment.getMarks()
        );
       }
       public Department deleteDepartment(int id){
        Department existingDepartment=departmentrepo.findByid(id)
                .orElseThrow(()->new RuntimeException("Department was not found by id:"+id));
        departmentrepo.deleteById(id);
        return existingDepartment;
       }
}
