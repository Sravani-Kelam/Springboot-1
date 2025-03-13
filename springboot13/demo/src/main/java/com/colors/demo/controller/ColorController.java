package com.colors.demo.controller;

import com.colors.demo.entity.ColorEntity;
import com.colors.demo.service.ImpleService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.sql.rowset.serial.SerialBlob;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Optional;

@RestController
@RequestMapping("/color")
@RequiredArgsConstructor
public class ColorController {
    @Autowired
    private ImpleService service;

    @PostMapping
    public ResponseEntity<ColorEntity> saveColor(
            @RequestParam("photo") MultipartFile photo,
            @RequestParam("name") String name,
            @RequestParam("frequency") double frequency) throws SQLException, IOException {
        ColorEntity savedColorEntity = service.saveColor(photo, name, frequency);
//        ColorDto colorDto=new ColorDto(savedColorEntity.getId(),savedColorEntity.getName(),savedColorEntity.getFrequency());
        return new ResponseEntity<>(savedColorEntity, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<ColorEntity>> getColor(@PathVariable ColorEntity id) throws SQLException, IOException {
        Optional<ColorEntity> colorEntity = service.getColor(id.getId());
        return new ResponseEntity<>(colorEntity, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Optional<ColorEntity>> updateColor(
            @PathVariable int id,
            @RequestParam(value = "photo", required = false) MultipartFile photo,
            @RequestParam("name") String name,
            @RequestParam("frequency") double frequency) throws SQLException, IOException {

        byte[] photoBytes = (photo != null && !photo.isEmpty()) ? photo.getBytes() : null;


        ColorEntity updatedColorEntity = service.updateColor(id, name, frequency, photoBytes);

        return ResponseEntity.ok(Optional.of(updatedColorEntity));
    }
  @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteColorEntity(@PathVariable int id){
        service.deleteColor(id);
        return new ResponseEntity<>(HttpStatus.OK);
  }
}