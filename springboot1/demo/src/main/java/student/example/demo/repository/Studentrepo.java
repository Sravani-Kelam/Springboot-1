package student.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import student.example.demo.Entity.Student;
import student.example.demo.dto.StudentDto;

import java.util.Optional;

public interface Studentrepo extends JpaRepository<Student,Long> {
  Optional<Student>findById(long id);
}
