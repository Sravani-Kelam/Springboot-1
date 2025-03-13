package com.course.demo.service;

import com.course.demo.entity.CourseEntity;
import com.course.demo.repository.CourseRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.sql.rowset.serial.SerialBlob;
import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ImpleService implements CourseService {
    @Autowired
    private CourseRepository courseRepository;

    public CourseEntity saveCourse(MultipartFile file, String name, double fee) throws SQLException, IOException {
        CourseEntity courseEntity = new CourseEntity();
        courseEntity.setFee(fee);
        courseEntity.setName(name);
        if (!file.isEmpty()) {
            byte[] photoBytes = file.getBytes();
           // byte[] photoBlob = new SerialBlob(photoBytes);
            courseEntity.setPhoto(photoBytes);
        }
        return courseRepository.save(courseEntity);
    }
    public Optional<CourseEntity> getCourse(Integer id)throws SQLException,IOException{
        return courseRepository.findById(id);
    }
    public CourseEntity updateCourse(Integer id,String name,Double fee,byte[] photobytes) {
        CourseEntity courseEntity = courseRepository.findByid(id).get();
        if (name != null) courseEntity.setName(name);
        if (fee != null) courseEntity.setFee(fee);
        if (photobytes != null && photobytes.length > 0) {  // Ensure correct variable name
            byte[] photobytes1 = new byte[0];
            courseEntity.setPhoto(photobytes1);
        }

        return courseRepository.save(courseEntity);
    }
    public void deleteCourse(int id){
        Optional<CourseEntity>theCourseEntity=courseRepository.findByid(id);
        if (theCourseEntity.isPresent()){
            courseRepository.deleteById(id);
        }
    }
}