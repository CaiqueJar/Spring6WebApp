package com.dias.spring6webapp.services;

import com.dias.spring6webapp.domain.Book;

public interface BookService {
    
    Iterable<Book> findAll();
}
