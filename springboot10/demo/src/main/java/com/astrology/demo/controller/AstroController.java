package com.astrology.demo.controller;

import com.astrology.demo.dto.AstroDto;
import com.astrology.demo.entity.AstroEntity;
import com.astrology.demo.service.ImpleService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/astro")
@RequiredArgsConstructor
public class AstroController {

    @Autowired
    private ImpleService service;

    @PostMapping("/saveastro")
    public ResponseEntity<AstroDto> saveAstro(@RequestBody AstroDto astroDto){
        AstroDto saveAstroDto=service.saveAstroEntity(astroDto);
        return new ResponseEntity<>(saveAstroDto, HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<AstroDto> getAstroEntity(@PathVariable int id){
        AstroDto astroDto=service.getByid(id);
        return new ResponseEntity<>(astroDto,HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<AstroDto>updateAstroEntity(@PathVariable int id,@RequestBody AstroDto astroDto){
        AstroDto updatedEntity=service.updateAstroEntity(id,astroDto);
        return new ResponseEntity<>(updatedEntity,HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<AstroEntity> deleteAstro(@PathVariable int id){
        AstroEntity astroEntity=service.deleteAstro(id);
        return new ResponseEntity<>(astroEntity,HttpStatus.OK);
    }
}
