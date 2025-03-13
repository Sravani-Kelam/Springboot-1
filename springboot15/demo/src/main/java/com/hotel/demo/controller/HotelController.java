package com.hotel.demo.controller;

import com.hotel.demo.entity.HotelEntity;
import com.hotel.demo.service.ImpleService;
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
@RequestMapping("/hotel")
@RequiredArgsConstructor
public class HotelController {

    @Autowired
    private ImpleService service;

    @PostMapping
    public ResponseEntity<HotelEntity> saveHotelEntity(
            @RequestParam("photo") MultipartFile photo,
            @RequestParam("name")String name,
            @RequestParam("money")double money)throws SQLException, IOException {
        HotelEntity savedHotel=service.saveHotel(photo,name,money);
        return new ResponseEntity<>(savedHotel, HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Optional<HotelEntity>> getHotel(@PathVariable HotelEntity id) throws SQLException, IOException {
        Optional<HotelEntity> hotelEntity= service.getHotel(id.getId());
        return new ResponseEntity<>(hotelEntity, HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Optional<HotelEntity>> updateColor(
            @PathVariable int id,
            @RequestParam(value = "photo", required = false) MultipartFile photo,
            @RequestParam("name") String name,
            @RequestParam("money") double money) throws SQLException, IOException {

        byte[] photoBytes = (photo != null && !photo.isEmpty()) ? photo.getBytes() : null;


        HotelEntity updatedHotelEntity = service.updateHotel(id, name,money, photoBytes);

        return ResponseEntity.ok(Optional.of(updatedHotelEntity));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHotelEntity(@PathVariable int id){
        service.deleteHotel(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
