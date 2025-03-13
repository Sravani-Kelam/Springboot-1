package student.example.demo.service;

import student.example.demo.dto.StudentDto;

public interface StudentService {

    StudentDto saveStudent(StudentDto studentDto);

    StudentDto getById(long id);

   StudentDto updateStudent(long id,StudentDto studentDto);
}
