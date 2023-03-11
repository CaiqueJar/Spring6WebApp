package com.dias.spring6webapp.domain;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // Cria automaticamente os métodos getters, setters, equals, hashcode e toString
@Builder // Cria automaticamente o método builder para instanciar objetos
@AllArgsConstructor // Cria automaticamente o construtor com todos os atributos da classe
@NoArgsConstructor // Cria automaticamente o construtor sem argumentos
@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true, nullable = false, length = 50)
    private String title;
    @Column(unique = true, nullable = false, length = 50)
    private String isbn;

    @ManyToMany
    @JoinTable(name = "author_book", joinColumns = @JoinColumn(name = "book_id"), inverseJoinColumns = @JoinColumn(name = "author_id"))
    private Set<Author> authors = new HashSet<>();

    @ManyToOne
    private Publisher publisher;
}
