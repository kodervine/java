package com.kodervine.book.controllers;

import com.kodervine.book.domain.entities.BookEntity;
import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log
public class BookController {

    @GetMapping(path = "/books")
    public BookEntity retrieveBook() {
        return BookEntity.builder()
                .isbn("1230-456-789")
                .title("Heheh book")
                .author("Hehehe Tkii")
                .yearPublished("2005")
                .build();
    }

    @PostMapping(path = "/books")
    public BookEntity createBook(@RequestBody final BookEntity bookEntity){
        log.info("God book: " +  bookEntity.toString());
        return bookEntity;
    }


}
