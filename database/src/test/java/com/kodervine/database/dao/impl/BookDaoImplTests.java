package com.kodervine.database.dao.impl;

import com.kodervine.database.TestDataUtil;
import com.kodervine.database.domain.Book;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
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
        Book book = TestDataUtil.createTestBookA();

        underTest.create(book);
        verify(jdbcTemplate).update(eq("INSERT INTO books (isbn, title, author_id) VALUES (?, ?, ?)"),
                eq("123-456-789"),
                eq("Heheh book"),
                eq(1L)

        );
    }

    @Test
    public void testThatFindOneBookGeneratesCorrectSql(){
        underTest.findOne("123-456-789");

        verify(jdbcTemplate).query(
                eq("SELECT isbn, title, author_id from books WHERE isbn = ? LIMIT 1"),
                ArgumentMatchers.<BookDaoImpl.BookRowMapper>any(),
                eq("123-456-789")
        );
    }

    @Test
    public void testThatFindManyGeneratesCorrectSql() {
        underTest.find();

        verify(jdbcTemplate).query(
                eq("SELECT isbn, title, author_id from books"),
                        ArgumentMatchers.<BookDaoImpl.BookRowMapper>any()
        );
    }

    @Test
    public void testThatUpdateGeneratesCorrectSql() {
        Book book = TestDataUtil.createTestBookA();
        underTest.update("123-456-789", book);

        verify(jdbcTemplate).update(
                "UPDATE books SET isbn = ? , title = ?, author_id = ? WHERE isbn = ?",
                "123-456-789", "Heheh book", 1L, "123-456-789");
    }
}

