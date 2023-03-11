package com.dias.spring6webapp.repositories;

import com.dias.spring6webapp.domain.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
