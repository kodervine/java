package com.kodervine.book.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kodervine.book.TestDataUtil;
import com.kodervine.book.domain.dto.BookDto;
import com.kodervine.book.domain.entities.BookEntity;
import com.kodervine.book.services.BookService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode =  DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD) // so the database is cleaned after each test
@AutoConfigureMockMvc
public class BookControllerIntegrationTests {

    private MockMvc mockMvc;

    private ObjectMapper objectMapper;

    private BookService bookService;

    @Autowired // make sure everything is injected
    public BookControllerIntegrationTests(MockMvc mockMvc, BookService bookService) {
        this.mockMvc = mockMvc;
        this.bookService = bookService;
        this.objectMapper = new ObjectMapper();
    }

    @Test
    public void  testThatCreateBookReturnsStatus201Created() throws Exception{
        BookDto bookDto = TestDataUtil.createTestBookDtoA(null);
        String createBookJson = objectMapper.writeValueAsString(bookDto);
        boolean bookExists = bookService.isExists(bookDto.getIsbn());

        if (bookExists) {
            mockMvc.perform(
                    MockMvcRequestBuilders.put("/books/" + bookDto.getIsbn())
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(createBookJson)

            ).andExpect(MockMvcResultMatchers.status().isOk());
        } else {
            mockMvc.perform(
                    MockMvcRequestBuilders.put("/books/" + bookDto.getIsbn())
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(createBookJson)

            ).andExpect(MockMvcResultMatchers.status().isCreated());
        }

    }


    @Test
    public void testThatCreateBookReturnsCreatedBook() throws Exception{
        BookDto bookDto = TestDataUtil.createTestBookDtoA(null);
        String createBookJson = objectMapper.writeValueAsString(bookDto);

        mockMvc.perform(
                MockMvcRequestBuilders.put("/books/" + bookDto.getIsbn())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(createBookJson)

        ).andExpect(
                MockMvcResultMatchers.jsonPath("$.isbn").value(bookDto.getIsbn())
        ).andExpect(
                MockMvcResultMatchers.jsonPath("$.title").value(bookDto.getTitle())
        );
    }

    @Test
    public void  testThatListBooksReturnsStatus20O() throws Exception{
        mockMvc.perform(
                MockMvcRequestBuilders.get("/books")
                        .contentType(MediaType.APPLICATION_JSON)

        ).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testThatListBooksReturnsBook() throws Exception {
       BookEntity testBookEntityA = TestDataUtil.createTestBookEntityA(null);
       bookService.createUpdateBook(testBookEntityA.getIsbn(), testBookEntityA);
        mockMvc.perform(
                MockMvcRequestBuilders.get("/books")
                        .contentType(MediaType.APPLICATION_JSON)

        ).andExpect(
                MockMvcResultMatchers.jsonPath("$[0].isbn").value("1230-456-789-3")
        ).andExpect(
                MockMvcResultMatchers.jsonPath("$[0].title").value("Heheh book 2")
        );
    }

    @Test
    public void  testThatGetBookReturnsStatus200WhenBookExists() throws Exception{
        BookEntity testBookEntityA = TestDataUtil.createTestBookEntityA(null);
        bookService.createUpdateBook(testBookEntityA.getIsbn(), testBookEntityA);
        mockMvc.perform(
                MockMvcRequestBuilders.get("/books/" + testBookEntityA.getIsbn())
                        .contentType(MediaType.APPLICATION_JSON)

        ).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void  testThatGetBookReturnsStatus404WhenBookDoesntExist() throws Exception{
         mockMvc.perform(
                MockMvcRequestBuilders.get("/books/123-456/2929")
                        .contentType(MediaType.APPLICATION_JSON)

        ).andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    @Test
    public void  testThatUpdateBookReturnsHttpStatus200() throws Exception{
        BookEntity testBookEntityA = TestDataUtil.createTestBookEntityA(null);
        BookEntity savedBookEntity = bookService.createUpdateBook(testBookEntityA.getIsbn(), testBookEntityA);

        BookDto bookDto = TestDataUtil.createTestBookDtoA(null);
        testBookEntityA.setIsbn(savedBookEntity.getIsbn());
        String createBookJson = objectMapper.writeValueAsString(bookDto);

        mockMvc.perform(
                MockMvcRequestBuilders.put("/books/" + savedBookEntity.getIsbn())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(createBookJson)

        ).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testThatUpdateBookReturnsUpdatedBook() throws Exception{
        BookEntity testBookEntityA = TestDataUtil.createTestBookEntityA(null);
        BookEntity savedBookEntity = bookService.createUpdateBook(testBookEntityA.getIsbn(), testBookEntityA);

        BookDto bookDto = TestDataUtil.createTestBookDtoA(null);
        testBookEntityA.setIsbn(savedBookEntity.getIsbn());
        testBookEntityA.setTitle("Updated");
        String createBookJson = objectMapper.writeValueAsString(bookDto);

        mockMvc.perform(
                MockMvcRequestBuilders.put("/books/" + savedBookEntity.getIsbn())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(createBookJson)

        ).andExpect(
                MockMvcResultMatchers.jsonPath("$.isbn").value("1230-456-789")
        ).andExpect(
                MockMvcResultMatchers.jsonPath("$.title").value("Heheh book 2")
        );
    }

}
