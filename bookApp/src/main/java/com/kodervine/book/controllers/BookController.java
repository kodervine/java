package com.kodervine.book.controllers;

import com.kodervine.book.domain.dto.BookDto;
import com.kodervine.book.domain.entities.BookEntity;
import com.kodervine.book.mappers.Mapper;
import com.kodervine.book.services.BookService;
import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
    public ResponseEntity<BookDto> createAndUpdateBook(
            @PathVariable("isbn") String isbn,
            @RequestBody BookDto bookDto) {
        BookEntity bookEntity = bookMapper.mapFrom(bookDto);
        boolean bookExists = bookService.isExists(isbn);
        BookEntity savedBookEntity = bookService.createUpdateBook(isbn, bookEntity);
        BookDto savedUpdatedBookDto = bookMapper.mapTo(savedBookEntity);

        if(bookExists){
            return new ResponseEntity(savedUpdatedBookDto, HttpStatus.OK);
        } else {
            return new ResponseEntity(savedUpdatedBookDto, HttpStatus.CREATED);
        }
   }

    @GetMapping("/books")
    public List<BookDto> listBooks() {
       List<BookEntity> books = bookService.findAll();
      return books.stream()
              .map(bookMapper::mapTo)
              .collect(Collectors.toList());
   }

   @GetMapping(path = "/books/{isbn}")
    public ResponseEntity<BookDto> getBook(@PathVariable("isbn") String isbn) {
       Optional<BookEntity> foundBook = bookService.findOne(isbn);
      return foundBook.map(bookEntity -> {
          BookDto bookDto = bookMapper.mapTo(bookEntity);
          return new ResponseEntity<>(bookDto, HttpStatus.OK);
       }).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
   }

   @PatchMapping(path = "/books/{isbn}")
    public ResponseEntity<BookDto> partialUpdateBook(
            @PathVariable("isbn") String isbn,
            @RequestBody BookDto bookDto
   ) {
        // take book dto and turn to book entity to work with service layer and persistence layer

       boolean bookExists = bookService.isExists(isbn);
       if (!bookExists) {
           return new ResponseEntity<>(HttpStatus.NOT_FOUND);
       }

       BookEntity bookEntity = bookMapper.mapFrom(bookDto);
       BookEntity updatedBookEntity = bookService.partialUpdate(isbn, bookEntity);
       return new ResponseEntity<>(bookMapper.mapTo(updatedBookEntity), HttpStatus.OK);
   }

   @DeleteMapping(path = "/books/{isbn}")
    public ResponseEntity deleteBook(@PathVariable("isbn") String isbn) {
        bookService.delete(isbn);
        return new ResponseEntity(HttpStatus.NO_CONTENT);

    }

}
