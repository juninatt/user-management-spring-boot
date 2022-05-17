package iths.not3book.sampledata;

import iths.not3book.authorities.Authority;
import iths.not3book.author.Author;
import iths.not3book.author.AuthorRepository;
import iths.not3book.authorities.AuthoritiesRepository;
import iths.not3book.document.Document;
import iths.not3book.document.DocumentRepository;
import iths.not3book.subscriber.Subscriber;
import iths.not3book.subscriber.SubscriberRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class UserDataConfig {

    @Bean
    CommandLineRunner commandLineRunner(
            AuthorRepository authorRepository,
            SubscriberRepository subscriberRepository,
            DocumentRepository documentRepository,
            AuthoritiesRepository authoritiesRepository) {
        return args -> {

                    Authority anaRead = new Authority("ana", "read");

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

            authoritiesRepository.save(anaRead);

            authorRepository.saveAll(
                    List.of(ana, peter, douglas, joel, brian, dumbledore)
            );
            subscriberRepository.saveAll(
                    List.of(karl, nils, anna, malin, robin)
            );
            documentRepository.saveAll(
                    List.of(bible, koran, HP1, HP2, storm, calm)
            );
        };
    }
}
