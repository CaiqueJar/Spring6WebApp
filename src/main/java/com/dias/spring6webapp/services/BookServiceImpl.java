package com.dias.spring6webapp.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.dias.spring6webapp.domain.Book;
import com.dias.spring6webapp.repositories.BookRepository;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    @Override
    public Iterable<Book> findAll() {
        return bookRepository.findAll();
    }
}
