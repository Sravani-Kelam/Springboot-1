package student.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import student.example.demo.Entity.Student;
import student.example.demo.dto.StudentDto;
import student.example.demo.repository.Studentrepo;

@org.springframework.stereotype.Service
//@AllArgsConstructor

public class ImplService implements StudentService {

    @Autowired
    private Studentrepo studentrepo;

    public StudentDto saveStudent(StudentDto studentDto){
        Student student=new Student(
                studentDto.getId(),
                studentDto.getName(),
                studentDto.getMarks(),
                studentDto.getBranch()
        );
        Student saveStudent=studentrepo.save(student);
        StudentDto savestudentDto=new StudentDto(
                saveStudent.getId(),
                saveStudent.getName(),
                saveStudent.getMarks(),
                saveStudent.getBranch()
        );
        return savestudentDto;
    }
    public StudentDto getById(long id){
        Student student=studentrepo.findById(id)
                .orElseThrow(()->new RuntimeException("student not found"));
        return new StudentDto(
                student.getId(),
                student.getName(),
                student.getMarks(),
                student.getBranch()
        );
    }
    public StudentDto updateStudent(long id, StudentDto studentDto){
        Student existingStudent=studentrepo.findById(id)
                .orElseThrow(()->new RuntimeException("student is not found by id:"+id));

        existingStudent.setBranch(studentDto.getBranch());
        existingStudent.setMarks(studentDto.getMarks());
        existingStudent.setName(studentDto.getName());

        Student updatedStudent=studentrepo.save(existingStudent);
        return new StudentDto(
                updatedStudent.getId(),
                updatedStudent.getName(),
                updatedStudent.getMarks(),
                updatedStudent.getBranch()
        );
    }

    public Student deleteStudent(long id){
        Student existingStudent=studentrepo.findById(id)
                .orElseThrow(()->new RuntimeException("Student was not found by id:"+id));
        studentrepo.deleteById(id);
        return existingStudent;
    }
}
