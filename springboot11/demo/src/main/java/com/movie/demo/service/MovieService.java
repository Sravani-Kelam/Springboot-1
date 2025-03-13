package com.movie.demo.service;

import com.movie.demo.dto.MovieDto;

public interface MovieService {
    MovieDto saveMovie(MovieDto movieDto);
    MovieDto getByid(int id);
    MovieDto updateMovie(int id,MovieDto movieDto);
}
