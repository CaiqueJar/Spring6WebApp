package com.dias.spring6webapp.controllers;

import com.dias.spring6webapp.domain.Book;
import com.dias.spring6webapp.services.BookService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/books")
@AllArgsConstructor
public class BookController {
    private final BookService bookService;

    @GetMapping // Mapeia a URL /api/v1/books/books para o método getBooks
    public ResponseEntity<List<Book>> getBooks() {
        List<Book> books = (List<Book>) bookService.findAll(); // Retorna um Iterable, mas o Jackson não consegue converter para JSON

        return new ResponseEntity<>(books, HttpStatus.OK); // Retorna um ResponseEntity, que encapsula o objeto de retorno e o status HTTP
    }
}
