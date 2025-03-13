package com.pro.jpa6.marker.controller;

import com.pro.jpa6.marker.dto.StudentDto;
import com.pro.jpa6.marker.entity.Students;
import com.pro.jpa6.marker.services.StudentService;
import com.pro.jpa6.marker.services.impl.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController

public class StudentController {
    @Autowired
    private StudentServiceImpl studentService;

    @PostMapping("/student")
    public ResponseEntity<StudentDto> saveStudent(@RequestBody StudentDto studentDto){
        StudentDto savestudents=studentService.savestudent(studentDto);

        return new ResponseEntity<>(savestudents, HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Students>getStudent(@PathVariable int id){
      Students student=studentService.getstudent(id);
      return new ResponseEntity<>(student,HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<StudentDto> updateStudents(
        @PathVariable int id,
                @RequestBody StudentDto studentDto){
    StudentDto updatedStudents=studentService.updateStudent(id,studentDto);
    return new ResponseEntity<>(updatedStudents,HttpStatus.OK);
        }
        @DeleteMapping("/{id}")
        public ResponseEntity<StudentDto>deleteStudents(@PathVariable int id){
        Students students=studentService.deleteStudents(id);
        return new ResponseEntity<>(students,HttpStatus.OK);
        }
    }

