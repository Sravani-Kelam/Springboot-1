package com.pro.jpa6.conductor.controller;

import com.pro.jpa6.conductor.dto.ConductorDto;
import com.pro.jpa6.conductor.entity.Conductor;
import com.pro.jpa6.conductor.services.impl.ConductorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController

public class ConductorController {
    @Autowired
    private ConductorServiceImpl conductorService;

    @PostMapping("/conductor")
    public ResponseEntity<ConductorDto> saveConductor(@RequestBody ConductorDto conductorDtoDto){
        ConductorDto saveconductor=conductorService.saveconductor(conductorDto);

        return new ResponseEntity<>(saveconductor, HttpStatus.CREATED);
    }
    @GetMapping("/{phn}")
    public ResponseEntity<Conductor>getConductor(@PathVariable int phn){
      Conductor conductor=conductorService.getconductor(phn);
      return new ResponseEntity<>(conductor,HttpStatus.OK);
    }
    @PutMapping("/{phn}")
    public ResponseEntity<ConductorDto> update(Conductor)
        @PathVariable int phn,
                @RequestBody ConductorDto conductorDto){
    ConductorDto updatedConductor=conductorService.updateConductor(phn,conductorDto);
    return new ResponseEntity<>(updatedConductor,HttpStatus.OK);
        }
        @DeleteMapping("/{phn}")
        public ResponseEntity<ConductorDto>deleteConductor(@PathVariable int phn){
        Conductor conductor =conductorService.deleteConductor(phn);
        return new ResponseEntity<>(conductor,HttpStatus.OK);
        }
    }

