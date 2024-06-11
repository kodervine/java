package com.kodervine.database.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "books")
public class Book {

    @Id

    private String isbn;

    private String title;

    // if we get a book, also get back the author so that changes made also applies/persists in the database
    // Case in point - instead of recreating authorDao in each test, this cascade allows to extract the author
    // details
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "author_id")
    private Author author;
}
