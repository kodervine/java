package com.kodervine.database.dao.impl;

import com.kodervine.database.dao.AuthorDao;
import com.kodervine.database.domain.Author;
import org.springframework.jdbc.core.JdbcTemplate;

public class AuthorDaoImpl implements AuthorDao {

    private JdbcTemplate jdbcTemplate;

    public AuthorDaoImpl(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void create(Author author) {
        jdbcTemplate.update(
                "INSERT INTO authors(id, name, age) VALUES (?, ?, ?)",
                author.getId(), author.getName(), author.getAge()
                );
    }
}
