package com.dias.spring6webapp.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data // Cria automaticamente os métodos getters, setters, equals, hashcode e toString
@Builder // Cria automaticamente o método builder para instanciar objetos
@AllArgsConstructor // Cria automaticamente o construtor com todos os atributos da classe
@NoArgsConstructor // Cria automaticamente o construtor sem argumentos
@Table(name = "publishers")
@Entity
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true, nullable = false, length = 50)
    private String name;
    @Column(unique = true, nullable = false, length = 50)
    private String address;
    @Column(unique = true, nullable = false, length = 50)
    private String city;
    @Column(unique = true, nullable = false, length = 50)
    private String state;
    @Column(unique = true, nullable = false, length = 50)
    private String zip;

    @OneToMany(mappedBy = "publisher")
    private Set<Book> books;
}
