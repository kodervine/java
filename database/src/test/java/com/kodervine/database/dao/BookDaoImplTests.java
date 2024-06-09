package com.kodervine.database.dao;

import com.kodervine.database.dao.impl.BookDaoImpl;
import com.kodervine.database.domain.Book;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class BookDaoImplTests {

    @Mock
    private JdbcTemplate jdbcTemplate;

    @InjectMocks
    private BookDaoImpl underTest;

    @Test
    public void testThatCreateBookGeneratesTheCorrectSql() {
        Book book = Book.builder()
                .isbn("123-456-789")
                .title("Heheh book")
                .authorId(1L)
                .build();

        underTest.create(book);

        verify(jdbcTemplate).update(eq("INSERT INTO books (isbn, title, author_id) VALUES (?, ?, ?)"),
                eq("123-456-789"),
                eq("Heheh book"),
                eq(1L)

        );

    }
}
