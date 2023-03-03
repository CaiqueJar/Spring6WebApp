package com.dias.spring6webapp.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.dias.spring6webapp.domain.Author;
import com.dias.spring6webapp.domain.Book;
import com.dias.spring6webapp.domain.Publisher;
import com.dias.spring6webapp.repositories.AuthorRepository;
import com.dias.spring6webapp.repositories.BookRepository;
import com.dias.spring6webapp.repositories.PublisherRepository;

@Component
public class BootstrapData implements CommandLineRunner{

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }


    @Override
    public void run(String... args) throws Exception {
        Author eric = new Author();
        eric.setFirstName("Eric");
        eric.setLastName("Evans");
        
        Book ddd = new Book();
        ddd.setTitle("Domain Drive Design");
        ddd.setIsbn("123456");

        Author ericSaved = authorRepository.save(eric);
        Book dddSaved = bookRepository.save(ddd);

        Publisher catapult = new Publisher();
        catapult.setName("Catapult");
        catapult.setAddress("Seila");
        catapult.setCity("New York city");
        catapult.setState("New york");
        catapult.setZip("08422422");
        Publisher savedPublisher = publisherRepository.save(catapult);

        dddSaved.setPublisher(savedPublisher);

        
        Author rod = new Author();
        rod.setFirstName("Rod");
        rod.setLastName("Johnson");

        Book noEJB = new Book();
        noEJB.setTitle("J2EE Development without EJB");
        noEJB.setIsbn("54757585");

        Author rodSaved = authorRepository.save(rod);
        Book noEJBSaved = bookRepository.save(noEJB);

        noEJBSaved.setPublisher(savedPublisher);

        ericSaved.getBooks().add(dddSaved);
        rodSaved.getBooks().add(noEJBSaved);
        dddSaved.getAuthors().add(ericSaved);
        noEJBSaved.getAuthors().add(rodSaved);

        // persisted
        authorRepository.save(ericSaved);
        authorRepository.save(rodSaved);
        bookRepository.save(dddSaved);
        bookRepository.save(noEJBSaved);

        System.out.println("In Bootstrap");
        System.out.println("Author Count: "+ authorRepository.count());
        System.out.println("Book Count: "+ bookRepository.count());
        System.out.println("Publisher Count: "+ publisherRepository.count());

    }
    
}
