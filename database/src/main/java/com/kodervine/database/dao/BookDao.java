package com.kodervine.database.dao;

import com.kodervine.database.domain.Book;

import java.util.Optional;

public interface BookDao {
    void create(Book book);

    Optional<Book> find(String isbn);
}
