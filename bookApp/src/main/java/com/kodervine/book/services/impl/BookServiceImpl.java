package com.kodervine.book.services.impl;

import com.kodervine.book.domain.entities.BookEntity;
import com.kodervine.book.repositories.BookRepository;
import com.kodervine.book.services.BookService;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {


    private BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public BookEntity createBook(String isbn, BookEntity book) {
        book.setIsbn(isbn);
        return bookRepository.save(book);
    }
}
