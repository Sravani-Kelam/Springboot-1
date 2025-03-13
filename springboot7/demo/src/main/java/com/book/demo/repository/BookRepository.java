package com.book.demo.repository;

import com.book.demo.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookRepository extends JpaRepository<BookEntity,Integer> {
Optional <BookEntity> findById(int id);
}
