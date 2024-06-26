package com.kodervine.book.services;

import com.kodervine.book.domain.entities.BookEntity;

import java.util.List;
import java.util.Optional;

// when I hover on the circle and arrow down cos of the 1 related problem it leads me to creating the impl
public interface BookService {

    BookEntity createUpdateBook(String isbn, BookEntity book);


    List<BookEntity> findAll();

    Optional<BookEntity> findOne(String isbn);

    boolean isExists(String isbn);

    BookEntity partialUpdate(String isbn, BookEntity bookEntity);

    void delete(String isbn);
}
