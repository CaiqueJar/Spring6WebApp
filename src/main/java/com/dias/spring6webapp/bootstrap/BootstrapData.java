package com.dias.spring6webapp.bootstrap;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.dias.spring6webapp.domain.Author;
import com.dias.spring6webapp.domain.Book;
import com.dias.spring6webapp.domain.Publisher;
import com.dias.spring6webapp.repositories.BookRepository;
import com.dias.spring6webapp.repositories.PublisherRepository;
import com.dias.spring6webapp.repositories.AuthorRepository;

import java.util.Set;

@Component
@RequiredArgsConstructor
public class BootstrapData implements CommandLineRunner {
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;
    private final AuthorRepository authorRepository;

    @Override
    public void run(String... args) throws Exception {
        Author eric = Author
                .builder()
                .firstName("Eric")
                .lastName("Evans")
                .build();
        
        Book ddd = Book
                .builder()
                .title("Domain Driven Design")
                .isbn("123123")
                .build();

        Author ericSaved = authorRepository.save(eric);
        Book dddSaved = bookRepository.save(ddd);

        Publisher catapult = Publisher
                .builder()
                .name("Catapult")
                .address("Rua dos Bobos, 0")
                .city("São Paulo")
                .state("SP")
                .zip("00000-000")
                .build();

        Publisher savedPublisher = publisherRepository.save(catapult);

        dddSaved.setPublisher(savedPublisher);
        
        Author rod = Author
                .builder()
                .firstName("Rod")
                .lastName("Johnson")
                .build();

        Book noEJB = Book
                .builder()
                .publisher(savedPublisher)
                .title("J2EE Development without EJB")
                .isbn("3939459459")
                .build();

        Author rodSaved = authorRepository.save(rod);
        Book noEJBSaved = bookRepository.save(noEJB);

        /*
        *   Criei uma lista de autores e outra de livros para associar os dois objetos
        *  e salvar no banco de dados. Porque tava dando erro de transação.
        * */
        Set<Author> authors = Set.of(ericSaved, rodSaved);
        Set<Book> books = Set.of(dddSaved, noEJBSaved);

        ericSaved.setBooks(books);
        rodSaved.setBooks(books);
        dddSaved.setAuthors(authors);
        noEJBSaved.setAuthors(authors);

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
