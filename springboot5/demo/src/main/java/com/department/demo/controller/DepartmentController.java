package com.department.demo.controller;

import com.department.demo.dto.DepartmentDto;
import com.department.demo.entity.Department;
import com.department.demo.service.ImplService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dept")
@RequiredArgsConstructor
public class DepartmentController {
    @Autowired
    private ImplService service;
    @PostMapping("/savedept")
    public ResponseEntity<DepartmentDto> saveDepartment(@RequestBody DepartmentDto departmentDto){
        DepartmentDto saveDepartment=service.saveDepartment(departmentDto);
        return new ResponseEntity<>(saveDepartment, HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<DepartmentDto> getDepartment(@PathVariable int id){
        DepartmentDto department=service.getByid(id);
        return new ResponseEntity<>(department,HttpStatus.OK);
    }
   @PutMapping("/{id}")
    public ResponseEntity<DepartmentDto> updateDepartment(@PathVariable int id,@RequestBody DepartmentDto departmentDto){
        DepartmentDto updatedDepartment=service.updateDepartment(id,departmentDto);
        return new ResponseEntity<>(updatedDepartment,HttpStatus.OK);
   }
   @DeleteMapping("/{id}")
    public ResponseEntity<Department> deleteDepartment(@PathVariable int id){
        Department department=service.deleteDepartment(id);
        return new ResponseEntity<>(department,HttpStatus.OK);
   }
}
