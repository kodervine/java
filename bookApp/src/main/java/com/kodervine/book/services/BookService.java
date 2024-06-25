package com.kodervine.book.services;

import com.kodervine.book.domain.entities.BookEntity;

public interface BookService {

    BookEntity createBook(String isbn, BookEntity book);


}
