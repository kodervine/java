package com.kodervine.book.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
// put updates every property. Patch returns only the selected attribute
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true) // ignore field it doesnt recognise
public class BookEntity {
    private String isbn;

    private String title;

    private String author;

    @JsonProperty("year") // don't want the match the property
    private String yearPublished;
}
