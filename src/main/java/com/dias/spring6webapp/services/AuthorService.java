package com.dias.spring6webapp.services;

import com.dias.spring6webapp.domain.Author;

public interface AuthorService {
    
    Iterable<Author> findAll();
}
