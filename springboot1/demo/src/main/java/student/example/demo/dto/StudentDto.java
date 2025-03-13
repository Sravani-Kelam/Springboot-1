package student.example.demo.dto;

public class StudentDto {

    private Long id;
    private String name;
    private Double marks;
    private String branch;

    public StudentDto(Long id, String name, Double marks, String branch) {
        this.id = id;
        this.name = name;
        this.marks = marks;
        this.branch = branch;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getMarks() {
        return marks;
    }

    public void setMarks(Double marks) {
        this.marks = marks;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }
}
