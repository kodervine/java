package com.kodervine.book.services;

import com.kodervine.book.domain.entities.AuthorEntity;

import java.util.List;

public interface AuthorService {
    AuthorEntity createAuthor (AuthorEntity authorEntity);

    List<AuthorEntity> findAll();
}