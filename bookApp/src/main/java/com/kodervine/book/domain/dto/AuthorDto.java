package com.kodervine.book.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor // make sure objects used with jackson has this noargs so jackson can create a new object
@Builder
public class AuthorDto {

    private Long id;
    private String name;
    private Integer age;
}
