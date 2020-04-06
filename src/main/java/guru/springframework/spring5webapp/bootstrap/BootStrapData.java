/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 *
 * @author koos
 */
@Component
public class BootStrapData implements CommandLineRunner
{

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository)
    {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception
    {
        Publisher mb = new Publisher("Mopani Books", "185 Steve Biko Rd", "Bela Bela", "Polokwane", "9870");
        publisherRepository.save(mb);
        
        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "123123", mb);

        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        mb.getBooks().add(ddd);

        
        authorRepository.save(eric);
        bookRepository.save(ddd);
        publisherRepository.save(mb); //Entity Changed - so save again

        
        Publisher juta = new Publisher("Juta", "462 Malibongwe Drive", "Roodepoort", "Gauteng", "1234");
        
        publisherRepository.save(juta);
        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "393459459", juta);
        
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);
        
        juta.getBooks().add(noEJB);

        
        authorRepository.save(rod);
        bookRepository.save(noEJB);
        publisherRepository.save(juta); //Entity Changed - so save again

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Publishers: " + publisherRepository.count());
        System.out.println("Number of Books: " + bookRepository.count());
        System.out.println("Number of Authors: " + authorRepository.count());
        
        System.out.println("Mopani Books Number of Books: " + mb.getBooks().size());
        System.out.println("Juta Number of Books: " + juta.getBooks().size());

    }

}
