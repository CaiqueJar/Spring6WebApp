package com.dias.spring6webapp.payload;

import lombok.Data;

@Data
public class BookDto {
    private String title;
    private String isbn;
    private String publisher;
}
