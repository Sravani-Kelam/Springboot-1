package com.book.demo.service;

import com.book.demo.dto.BookDto;
import org.springframework.beans.factory.annotation.Autowired;

public interface BookService {
    BookDto saveBook(BookDto bookDto);
    BookDto getByid(int id);
    BookDto updateBookEntity(int id,BookDto bookDto);
}
