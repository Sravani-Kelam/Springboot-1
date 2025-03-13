package student.example.demo.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.Objects;

@Data
@jakarta.persistence.Entity
@Table(name="student1")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
   private Double marks;
   private String branch;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Student(Long id, String name, Double marks, String branch) {
        this.id = id;
        this.name = name;
        this.marks = marks;
        this.branch = branch;
    }

    public Student(String name, Double marks, String branch) {
        this.name = name;
        this.marks = marks;
        this.branch = branch;
    }
    public  Student(){
        super();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(id, student.id) && Objects.equals(name, student.name) && Objects.equals(marks, student.marks) && Objects.equals(branch, student.branch);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, marks, branch);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", marks=" + marks +
                ", branch='" + branch + '\'' +
                '}';
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMarks(Double marks) {
        this.marks = marks;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public Double getMarks() {
        return marks;
    }

    public String getBranch() {
        return branch;
    }
}
