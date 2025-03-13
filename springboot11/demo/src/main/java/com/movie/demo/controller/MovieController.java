package com.movie.demo.controller;

import com.movie.demo.dto.MovieDto;
import com.movie.demo.entity.MovieEntity;
import com.movie.demo.service.ImplService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mov")
@RequiredArgsConstructor
public class MovieController {
    @Autowired
    private ImplService service;

    @PostMapping("/savemov")
    public ResponseEntity<MovieDto> saveMovie(@RequestBody MovieDto movieDto){
        MovieDto saveMovie=service.saveMovie(movieDto);
        return new ResponseEntity<>(saveMovie, HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<MovieDto> getMovie(@PathVariable int id){
        MovieDto movieDto=service.getByid(id);
        return new ResponseEntity<>(movieDto,HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<MovieDto>updateMovie(@PathVariable int id,@RequestBody MovieDto movieDto){
        MovieDto updatedMovie=service.updateMovie(id,movieDto);
        return new ResponseEntity<>(updatedMovie,HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<MovieEntity>deleteMovie(@PathVariable int id){
        MovieEntity movieEntity=service.deleteMovie(id);
        return new ResponseEntity<>(movieEntity,HttpStatus.OK);
    }
}
