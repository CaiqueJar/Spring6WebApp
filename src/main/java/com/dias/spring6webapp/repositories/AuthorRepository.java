package com.dias.spring6webapp.repositories;

import org.springframework.data.repository.CrudRepository;

import com.dias.spring6webapp.domain.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {
    
    
}
