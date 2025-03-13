package com.phone.demo.controller;

import com.phone.demo.dto.PhnDto;
import com.phone.demo.entity.Phone;
import com.phone.demo.service.ImplService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/phn")
@RequiredArgsConstructor
public class PhnController {

    @Autowired
    private ImplService service;

    @PostMapping("/savephn")
    public ResponseEntity<PhnDto> savePhn(@RequestBody PhnDto phnDto){
        PhnDto savedphone= service.savephn(phnDto);
        return new ResponseEntity<>(savedphone, HttpStatus.CREATED);
    }
    @GetMapping("/{phnnum}")
    public ResponseEntity<PhnDto> getPhn(@PathVariable long phnnum){
            PhnDto phone=service.getByphnnum(phnnum);
            return new ResponseEntity<>(phone,HttpStatus.OK);
    }

    @PutMapping("/{phnnum}")
    public ResponseEntity<PhnDto> updatePhone(@PathVariable long phnnum,@RequestBody PhnDto phnDto){
        PhnDto updatedPhone=service.updatePhone(phnnum,phnDto);
        return new ResponseEntity<>(updatedPhone,HttpStatus.OK);
    }
    @DeleteMapping("/{phnnum}")
    public ResponseEntity<Void> deletePhn(@PathVariable long phnnum) {
        service.deletePhone(phnnum);
        return ResponseEntity.noContent().build();
    }

}
