package com.kodervine.book.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity // don't want presentation layer to have knowledge of how persistence layer works
@Table(name = "authors")
public class AuthorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "author_id_seq")
    // anytime we create a new author, the database auto generates an id if we don't provide any
    // long and Integer is capitalized cos it could be null
    private Long id;
    private String name;
    private Integer age;

}
