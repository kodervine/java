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
@Table(name = "authors")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "author_id_seq")
    // anytime we create a new author, the database auto generates an id if we don't provide any
    // long and Integer is capitalized cos it could be null
    private Long id;
    private String name;
    private Integer age;

}
