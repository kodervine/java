package com.kodervine.database;

import com.kodervine.database.domain.Author;
import com.kodervine.database.domain.Book;

public final class TestDataUtil {
    private TestDataUtil () {

    }

    public static Author createTestAuthorA() {
        return Author.builder()
                .id(1L)
                .name("TKii hehe")
                .age(40)
                .build();
    }

    public static Author createTestAuthorB() {
        return Author.builder()
                .id(2L)
                .name("B Author")
                .age(50)
                .build();
    }

    public static Author createTestAuthorC() {
        return Author.builder()
                .id(3L)
                .name("C Author")
                .age(60)
                .build();
    }

    public static Author createTestAuthorD() {
        return Author.builder()
                .id(4L)
                .name("D Author")
                .age(70)
                .build();
    }

    public static Book createTestBookA(final Author author) {
        return Book.builder()
                .isbn("123-456-789")
                .title("Heheh book")
                .author(author)
                .build();
    }

    public static Book createTestBookB(final Author author) {
        return Book.builder()
                .isbn("456-789-123")
                .title("Book 2")
                .author(author)
                .build();
    }

    public static Book createTestBookC(final Author author) {
        return Book.builder()
                .isbn("789-123-456")
                .title("Book 3")
                .author(author)
                .build();
    }
}
