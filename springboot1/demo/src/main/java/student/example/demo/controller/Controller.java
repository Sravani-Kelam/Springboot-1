package student.example.demo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import student.example.demo.Entity.Student;
import student.example.demo.dto.StudentDto;
import student.example.demo.service.ImplService;

@RestController
@RequestMapping("/student")
@RequiredArgsConstructor
public class Controller {
    @Autowired
    private ImplService service;

    @PostMapping("/savestudent")
    public ResponseEntity<StudentDto> saveStudent(@RequestBody StudentDto studentDto){
        StudentDto saveStudent=service.saveStudent(studentDto);
        return new ResponseEntity<>(saveStudent, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDto>getStudent(@PathVariable long id){
        StudentDto student=service.getById(id);
        return new ResponseEntity<>(student,HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentDto> updateStudent(@PathVariable long id,@RequestBody StudentDto studentDto){
        StudentDto updatedStudent=service.updateStudent(id,studentDto);
        return new ResponseEntity<>(updatedStudent,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Student> deleteStudent(@PathVariable long id){
        Student student=service.deleteStudent(id);
        return new ResponseEntity<>(student,HttpStatus.OK);
    }
}
