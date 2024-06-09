package com.kodervine.database.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Author {

    // long and Integer is capitalized cos it could be null
    private Long id;
    private String name;
    private Integer age;

}
