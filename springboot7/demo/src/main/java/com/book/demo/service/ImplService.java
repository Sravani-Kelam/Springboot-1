package com.book.demo.service;

import com.book.demo.dto.BookDto;
import com.book.demo.entity.BookEntity;
import com.book.demo.repository.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ImplService implements BookService{
    @Autowired
    private BookRepository bookrepo;
    public BookDto saveBook(BookDto bookDto ){
        BookEntity bookEntity=new BookEntity(
                bookDto.getId(),
                bookDto.getName(),
                bookDto.getPage()
        );
        BookEntity saveBook=bookrepo.save(bookEntity);
        BookDto savebookDto=new BookDto(
                saveBook.getId(),
               saveBook.getName(),
                saveBook.getPage()
        );
        return savebookDto;
    }
    public BookDto getByid(int id){
        BookEntity bookEntity=bookrepo.findById(id)
                .orElseThrow(()->new RuntimeException("book not found"));
        return new BookDto(
                bookEntity.getId(),
                bookEntity.getName(),
                bookEntity.getPage()
        );
    }

    public BookDto updateBookEntity(int id,BookDto bookDto){
        BookEntity existingBook=bookrepo.findById(id)
                .orElseThrow(()->new RuntimeException("book is not found by id:"+id));

        existingBook.setName(bookDto.getName());
        existingBook.setPage(bookDto.getPage());

        BookEntity updatedBookEntity=bookrepo.save(existingBook);
        return new BookDto(
                updatedBookEntity.getId(),
                updatedBookEntity.getName(),
                updatedBookEntity.getPage()
        );
    }

    public BookEntity deleteBookEntity(int id){
        BookEntity existingBookEntity=bookrepo.findById(id)
                .orElseThrow(()->new RuntimeException("book was not found by id:"+id));
        bookrepo.deleteById(id);
        return existingBookEntity;
    }
}
