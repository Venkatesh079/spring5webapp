package com.springframework.spring5webapp.bootstrap;

import com.springframework.spring5webapp.domain.Author;
import com.springframework.spring5webapp.domain.Book;
import com.springframework.spring5webapp.domain.Publisher;
import com.springframework.spring5webapp.repositories.AuthorRepository;
import com.springframework.spring5webapp.repositories.BookRepository;
import com.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception{

        Author author = new Author("Eric", "Evans");
        Book book1 = new Book("Java and Spring Hands On", "1232");
        author.getBooks().add(book1);
        book1.getAuthors().add(author);

        authorRepository.save(author);
        bookRepository.save(book1);

        Author author1 = new Author("Rod", "Jhonson");
        Book book2 = new Book("J2EE Complete Reference", "52632");
        author.getBooks().add(book2);
        book2.getAuthors().add(author1);


        authorRepository.save(author1);
        bookRepository.save(book2);

        Publisher publisher = new Publisher("John","Church Street", "NewYork City", "NewYork","278823");
        book1.setPublisher(publisher);
        publisher.getBooks().add(book1);
        book2.setPublisher(publisher);
        publisher.getBooks().add(book2);
        System.out.println("Publisher is : " + publisherRepository.save(publisher));
        System.out.println("Publisher is : " + publisher.getBooks().size());

        System.out.println("In BootStrap");
        System.out.println("No of Books: " + bookRepository.count());


    }
}
