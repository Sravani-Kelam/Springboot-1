package com.rapido.demo.controller;

import com.rapido.demo.dto.RapidoDto;
import com.rapido.demo.entity.RapidoEntity;
import com.rapido.demo.service.ImplService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rap")
@RequiredArgsConstructor
public class RapidoController {
    @Autowired
    private ImplService service;

    @PostMapping("/saverap")
    public ResponseEntity<RapidoDto> saveRapido(@RequestBody RapidoDto rapidoDto){
        RapidoDto rapido=service.saveRapido(rapidoDto);
        return new ResponseEntity<>(rapido, HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<RapidoDto>getRapidoEntity(@PathVariable int id){
        RapidoDto rapido=service.getByid(id);
        return new ResponseEntity<>(rapido,HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<RapidoDto>updateRapido(@PathVariable int id,@RequestBody RapidoDto rapidoDto){
        RapidoDto updatedRapido=service.updateRapido(id,rapidoDto);
        return new ResponseEntity<>(updatedRapido,HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<RapidoEntity> deleteRapido(@PathVariable int id){
        RapidoEntity rapidoEntity=service.deleteRapido(id);
        return new ResponseEntity<>(rapidoEntity,HttpStatus.OK);
    }
}
