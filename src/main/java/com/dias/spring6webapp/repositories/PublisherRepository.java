package com.dias.spring6webapp.repositories;

import org.springframework.data.repository.CrudRepository;

import com.dias.spring6webapp.domain.Publisher;

public interface PublisherRepository extends CrudRepository<Publisher, Long>{
    
}
