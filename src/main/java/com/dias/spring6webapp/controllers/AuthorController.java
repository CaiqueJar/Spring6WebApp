package com.dias.spring6webapp.controllers;

import com.dias.spring6webapp.domain.Author;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.dias.spring6webapp.services.AuthorService;

import java.util.List;

@RestController // Usa o Jackson para converter o retorno para JSON
@RequestMapping("/api/v1/authors") // Boa prática: versionar a API
@AllArgsConstructor // Cria um construtor com todos os atributos da classe
public class AuthorController {
    private final AuthorService authorService;

    @GetMapping // Mapeia a URL /api/v1/authors para o método getAuthors
    public ResponseEntity<List<Author>> getAuthors() {
        List<Author> authors = (List<Author>) authorService.findAll(); // Retorna um Iterable, mas o Jackson não consegue converter para JSON

        return new ResponseEntity<>(authors, HttpStatus.OK); // Retorna um ResponseEntity, que encapsula o objeto de retorno e o status HTTP
    }
}
