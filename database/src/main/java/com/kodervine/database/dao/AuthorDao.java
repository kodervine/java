package com.kodervine.database.dao;

import com.kodervine.database.domain.Author;

import java.util.Optional;

public interface AuthorDao {
    void create(Author author);

   Optional<Author> findOne(long l);
}
