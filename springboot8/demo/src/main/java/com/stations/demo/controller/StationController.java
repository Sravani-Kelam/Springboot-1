package com.stations.demo.controller;

import com.stations.demo.dto.StationDto;
import com.stations.demo.entity.StationEntity;
import com.stations.demo.service.ImplService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/station")
@RequiredArgsConstructor
public class StationController {

    @Autowired
    private ImplService service;

    @PostMapping("/savestation")
    public ResponseEntity<StationDto>saveStation(@RequestBody StationDto stationDto){
        StationDto savedStation=service.saveStation(stationDto);
        return new ResponseEntity<>(savedStation, HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<StationDto>getStation(@PathVariable int id){
        StationDto stationDto=service.getByid(id);
        return new ResponseEntity<>(stationDto,HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<StationDto> updateStation(@PathVariable int id,@RequestBody StationDto stationDto){
        StationDto updatedStation=service.updateStation(id,stationDto);
        return new ResponseEntity<>(updatedStation,HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<StationEntity>deleteStation(@PathVariable int id){
        StationEntity stationEntity=service.deleteStationEntity(id);
        return new ResponseEntity<>(stationEntity,HttpStatus.OK);
    }
}
