package com.movie.demo.service;

import com.movie.demo.dto.MovieDto;
import com.movie.demo.entity.MovieEntity;
import com.movie.demo.repository.MovieRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ImplService implements MovieService{
    @Autowired
    private MovieRepository movieRepository;

    public MovieDto saveMovie(MovieDto movieDto){
        MovieEntity movieEntity=new MovieEntity(
                movieDto.getId(),
                movieDto.getName(),
                movieDto.getBudget(),
                movieDto.getTym()
        );
        MovieEntity saveMovie=movieRepository.save(movieEntity);

        MovieDto saveMovieDto=new MovieDto(
                saveMovie.getId(),
                saveMovie.getName(),
                saveMovie.getBudget(),
                saveMovie.getTym()
        );
        return saveMovieDto;
    }
    public MovieDto getByid(int id){
        MovieEntity movieEntity=movieRepository.findByid(id)
                .orElseThrow(()->new RuntimeException("movie is not found"));
        return new MovieDto(
                movieEntity.getId(),
                movieEntity.getName(),
                movieEntity.getBudget(),
                movieEntity.getTym()
        );
    }
    public  MovieDto updateMovie(int id , MovieDto movieDto){
        MovieEntity existingMovie=movieRepository.findByid(id)
                .orElseThrow(()->new RuntimeException("movie is not found by id:"+id));

        existingMovie.setName(movieDto.getName());
        existingMovie.setBudget(movieDto.getBudget());
        existingMovie.setTym(movieDto.getTym());

        MovieEntity updatedMovie=movieRepository.save(existingMovie);
        return new MovieDto(
                updatedMovie.getId(),
                updatedMovie.getName(),
                updatedMovie.getBudget(),
                updatedMovie.getTym()
        );
    }
    public MovieEntity deleteMovie(int id){
        MovieEntity existingMovie=movieRepository.findByid(id)
                .orElseThrow(()->new RuntimeException("movie is not found by id:"+id));
        movieRepository.deleteById(id);

        return existingMovie;
    }

}
