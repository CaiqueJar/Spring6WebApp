package com.dias.spring6webapp.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.dias.spring6webapp.domain.Author;
import com.dias.spring6webapp.repositories.AuthorRepository;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;

    @Override
    public Iterable<Author> findAll() {
        return authorRepository.findAll();
    }
    
}
