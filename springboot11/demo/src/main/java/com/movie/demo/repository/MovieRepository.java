package com.movie.demo.repository;

import com.movie.demo.entity.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MovieRepository extends JpaRepository<MovieEntity,Integer> {
    Optional<MovieEntity> findByid(int id);
}
