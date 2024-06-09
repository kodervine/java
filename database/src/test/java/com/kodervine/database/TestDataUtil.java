package com.kodervine.database;

import com.kodervine.database.domain.Author;
import com.kodervine.database.domain.Book;

public final class TestDataUtil {
    private TestDataUtil () {

    }

    public static Author createTestAuthor() {
        return Author.builder()
                .id(1L)
                .name("TKii hehe")
                .age(40)
                .build();
    }

    public static Book createTestBook() {
        return Book.builder()
                .isbn("123-456-789")
                .title("Heheh book")
                .authorId(1L)
                .build();
    }
}
