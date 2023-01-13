package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {
    private  final AuthorRepository authorRepository;
    private  final BookRepository bookRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args)  throws Exception {

        Author eric= new Author("Eric","Evans");
        Book ddd=new Book("DomainDriver dessigne","123456");
       eric.getBoos().add(ddd);
       ddd.getAuthors().add(eric);

       authorRepository.save(eric);
       bookRepository.save(ddd);

        Author rod= new Author("Rod","Jhnson");
        Book noEjb= new Book("J2ee","123456");

        rod.getBoos().add(noEjb);
        noEjb.getAuthors().add(rod);

        authorRepository.save(rod);
        bookRepository.save(noEjb);

        System.out.println("Started in bootstrap");
        System.out.println("Number of book s "+bookRepository.count());

    }
}
