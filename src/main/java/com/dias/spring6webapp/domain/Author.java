package com.dias.spring6webapp.domain;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;
import lombok.*;

@Data // Cria automaticamente os métodos getters, setters, equals, hashcode e toString
@Builder // Cria automaticamente o método builder para instanciar objetos
@AllArgsConstructor // Cria automaticamente o construtor com todos os atributos da classe
@NoArgsConstructor // Cria automaticamente o construtor sem argumentos
@Entity
@Table(name = "authors")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true, nullable = false, length = 50)
    private String firstName;
    @Column(unique = true, nullable = false, length = 50)
    private String lastName;
    @ManyToMany(mappedBy = "authors")
    private Set<Book> books = new HashSet<>();
}
