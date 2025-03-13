package com.book.demo.controller;

import com.book.demo.dto.BookDto;
import com.book.demo.entity.BookEntity;
import com.book.demo.service.ImplService;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private ImplService service;

    @PostMapping("/savebook")
    public ResponseEntity<BookDto> saveBookEntity(@RequestBody BookDto bookDto){
        BookDto saveBookEntity=service.saveBook(bookDto);
        return new ResponseEntity<>(saveBookEntity, HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<BookDto> getBookEntity(@PathVariable int id){
        BookDto book=service.getByid(id);
        return new ResponseEntity<>(book,HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookDto> updateBookEntity(@PathVariable int id,@RequestBody BookDto bookDto ){
        BookDto updatedBookEntity=service.updateBookEntity(id,bookDto);
        return new ResponseEntity<>(updatedBookEntity,HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<BookEntity> deleteBookEntity(@PathVariable int id){
        BookEntity bookEntity=service.deleteBookEntity(id);
        return new ResponseEntity<>(bookEntity,HttpStatus.OK);
    }

}
