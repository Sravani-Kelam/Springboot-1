package com.pro.jpa6.marker.services.impl;
import com.pro.jpa6.marker.dto.StudentDto;
import com.pro.jpa6.marker.entity.Students;
import com.pro.jpa6.marker.repository.StudentRepository;
import com.pro.jpa6.marker.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public StudentDto savestudent(StudentDto studentDto){
        Students student=new Students(
                studentDto.getId(),
                studentDto.getName(),
                studentDto.getDepartment()
        );
        Students savestudent=studentRepository.save(student);
        StudentDto studentDto1=new StudentDto(
                savestudent.getId(),
                savestudent.getName(),
                savestudent.getDepartment()
        );
        return studentDto1;
    }
    public Students getstudent(int id){
        Students student=studentRepository.findByid(id);
        return student;
    }
        public StudentDto updateStudent(int id, StudentDto studentDto){
            Students existingStudents=studentRepository.findById(id)
                    .orElseThrow(()->new RuntimeException("Students not found by id:"+id));

            existingStudents.setName(studentDto.getName());
            existingStudents.setDepartment(studentDto.getDepartment());

            Students updatedStudents=studentRepository.save(existingStudents);
            return new StudentDto(
                    updatedStudents.getId(),
                    updatedStudents.getName(),
                    updatedStudents.getDepartment()
            );
        }
        public StudentDto deleteStudents(int id){
        StudentDto studentDto=studentRepository.deleteByid(id);
        return studentDto;
        }
    }

