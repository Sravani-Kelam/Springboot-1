package com.course.demo.controller;

import com.course.demo.entity.CourseEntity;
import com.course.demo.service.ImpleService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Optional;

@RestController
@RequestMapping("/course")
@RequiredArgsConstructor
public class CourseController {
    @Autowired
    private ImpleService service;

    @PostMapping
    public ResponseEntity<CourseEntity> saveCourseEntity(
            @RequestParam("photo") MultipartFile photo,
            @RequestParam("name")String name,
            @RequestParam("fee")double fee)throws SQLException, IOException {
        CourseEntity savedCourse=service.saveCourse(photo,name,fee);
        return new ResponseEntity<>(savedCourse, HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Optional<CourseEntity>> getCourse(@PathVariable CourseEntity id) throws SQLException, IOException {
        Optional<CourseEntity> courseEntity = service.getCourse(id.getId());
        return new ResponseEntity<>(courseEntity, HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Optional<CourseEntity>> updateColor(
            @PathVariable int id,
            @RequestParam(value = "photo", required = false) MultipartFile photo,
            @RequestParam("name") String name,
            @RequestParam("fee") double fee) throws SQLException, IOException {

        byte[] photoBytes = (photo != null && !photo.isEmpty()) ? photo.getBytes() : null;


        CourseEntity updatedCourseEntity = service.updateCourse(id, name, fee, photoBytes);

        return ResponseEntity.ok(Optional.of(updatedCourseEntity));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteColorEntity(@PathVariable int id){
        service.deleteCourse(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
