package iths.not3book.sampledata;

import iths.not3book.author.Author;
import iths.not3book.author.AuthorRepository;
import iths.not3book.authorities.AuthoritiesRepository;
import iths.not3book.authorities.Authority;
import iths.not3book.document.Document;
import iths.not3book.document.DocumentRepository;
import iths.not3book.subscriber.Subscriber;
import iths.not3book.subscriber.SubscriberRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * Configuration class that creates sample data.
 */
@Configuration
public class UserDataConfig {

    /**
     * Method that injects some sample data to perform tests with
     * @param authorRepository Creates {@link Author} and sets values to fields 'userName', 'password' and 'enabled'.
     * @param subscriberRepository Creates {@link Subscriber} and sets values to fields 'userName and 'password'.
     * @param documentRepository Creates {@link Document} and sets value to the 'title' field.
     * @param authoritiesRepository Creates {@link Authority} and sets values to fields 'userName' and 'authority'.
     */
    @Bean
    CommandLineRunner commandLineRunner(
            AuthorRepository authorRepository,
            SubscriberRepository subscriberRepository,
            DocumentRepository documentRepository,
            AuthoritiesRepository authoritiesRepository) {
        return args -> {

                    Author ana = new Author("ana", "password", 1);
                    Author peter = new Author("peter", "password", 1);
                    Author douglas = new Author("dog", "password", 1);
                    Author joel = new Author("joel", "password", 1);
                    Author brian = new Author("brian", "password", 1);
                    Author dumbledore = new Author("dumbledore", "password", 1);

                    Subscriber karl = new Subscriber("Karl", "password");
                    Subscriber nils = new Subscriber("Nils", "password");
                    Subscriber anna = new Subscriber("Anna", "password");
                    Subscriber malin = new Subscriber("Malin", "password");
                    Subscriber robin = new Subscriber("Robin", "password");

                    Document bible = new Document("bible");
                    Document koran = new Document("koran");
                    Document HP1 = new Document("Harry Potter and The Philosophers Stone");
                    Document HP2 = new Document("Harry Potter and Hermiones Crazy Summer");
                    Document storm = new Document("Storm");
                    Document calm = new Document("Calm");

                    Authority anaRead = new Authority("ana", "read");


            authorRepository.saveAll(
                    List.of(ana, peter, douglas, joel, brian, dumbledore)
            );
            subscriberRepository.saveAll(
                    List.of(karl, nils, anna, malin, robin)
            );
            documentRepository.saveAll(
                    List.of(bible, koran, HP1, HP2, storm, calm)
            );
            authoritiesRepository.save(anaRead);
        };
    }
}
