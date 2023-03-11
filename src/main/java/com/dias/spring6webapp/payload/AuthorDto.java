package com.dias.spring6webapp.payload;

import lombok.Data;

import java.util.Set;

@Data
public class AuthorDto {
    private String firstName;
    private String lastName;
    private Set<BookDto> books;
}
