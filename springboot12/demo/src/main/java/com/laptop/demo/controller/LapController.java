package com.laptop.demo.controller;

import com.laptop.demo.dto.LapDto;
import com.laptop.demo.entity.LapEntity;
import com.laptop.demo.service.ImplService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/lap")
@RequiredArgsConstructor
public class LapController {

    @Autowired
    private ImplService service;

    @PostMapping("/savelap")
    public ResponseEntity<LapDto> saveLap(@RequestBody LapDto lapDto){
        LapDto savedLap=service.saveLap(lapDto);
        return new ResponseEntity<>(savedLap, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LapDto>getLap(@PathVariable int id){
        LapDto Lap=service.getByid(id);
        return new ResponseEntity<>(Lap,HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<LapDto> updateLap(@PathVariable int id,@RequestBody LapDto lapDto){
        LapDto updatedLap=service.updateLap(id,lapDto);
        return new ResponseEntity<>(updatedLap,HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<LapEntity>deleteLapEntity(@PathVariable int id){
        LapEntity lapEntity=service.deleteLap(id);
        return new ResponseEntity<>(lapEntity,HttpStatus.OK);
    }
}
