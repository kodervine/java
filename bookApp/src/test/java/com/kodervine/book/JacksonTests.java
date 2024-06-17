package com.kodervine.book;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kodervine.book.domain.entities.BookEntity;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class JacksonTests {
    @Test
    public void testThatObjectMapperCanCreateJsonFromJavaObject() throws JsonProcessingException {
        ObjectMapper objectMapper =  new ObjectMapper();
        BookEntity bookEntity = BookEntity.builder()
                .isbn("1230-456-789")
                .title("Heheh book")
                .author("Hehehe Tkii")
                .yearPublished("2005")
                .build();

       String result =  objectMapper.writeValueAsString(bookEntity);
     assertThat(result).isEqualTo("{\"isbn\":\"1230-456-789\",\"title\":\"Heheh book\"," +
             "\"author\":\"Hehehe Tkii\",\"year\":\"2005\"}");
    }

    @Test
    public void testThaTObjectMapperCanCreateJavaObjectFromJsonObject ()  throws JsonProcessingException{
        BookEntity bookEntity = BookEntity.builder()
                .isbn("1230-456-789")
                .title("Heheh book")
                .author("Hehehe Tkii")
                .yearPublished("2005")
                .build();

        String json = "{\"foo\":\"bar\",\"isbn\":\"1230-456-789\",\"title\":\"Heheh book\",\"author\":\"Hehehe Tkii\",\"year\":\"2005\"}";

        final ObjectMapper objectMapper = new ObjectMapper();
        BookEntity result = objectMapper.readValue(json, BookEntity.class);
        assertThat(result).isEqualTo(bookEntity);

    }
}
