package com.kodervine.book.controllers;

import com.kodervine.book.domain.dto.BookDto;
import com.kodervine.book.domain.entities.BookEntity;
import com.kodervine.book.mappers.Mapper;
import com.kodervine.book.services.BookService;
import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Log
public class BookController {

    private Mapper<BookEntity, BookDto> bookMapper;

    private BookService bookService;

    public BookController(Mapper<BookEntity, BookDto> bookMapper, BookService bookService) {
        this.bookMapper = bookMapper;
        this.bookService = bookService;
    }

    @PutMapping("/books/{isbn}")
    public ResponseEntity<BookDto> createBook(
            @PathVariable("isbn") String isbn,
            @RequestBody BookDto bookDto) {
      BookEntity bookEntity = bookMapper.mapFrom(bookDto);
     BookEntity savedBookEntity = bookService.createBook(isbn, bookEntity);
     BookDto savedBookDto = bookMapper.mapTo(savedBookEntity);

     return new ResponseEntity<>(savedBookDto, HttpStatus.CREATED);

   }

}
