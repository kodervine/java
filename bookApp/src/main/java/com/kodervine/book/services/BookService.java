package com.kodervine.book.services;

import com.kodervine.book.domain.entities.BookEntity;

import java.util.List;

// when I hover on the circle and arrow down cos of the 1 related problem it leads me to creating the impl
public interface BookService {

    BookEntity createBook(String isbn, BookEntity book);


    List<BookEntity> findAll();
}
