package iths.not3book.config;

import iths.not3book.author.Author;
import iths.not3book.author.AuthorRepository;
import iths.not3book.document.Document;
import iths.not3book.document.DocumentRepository;
import iths.not3book.subscriber.Subscriber;
import iths.not3book.subscriber.SubscriberRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class UserConfig {

    @Bean
    CommandLineRunner commandLineRunner(
            AuthorRepository authorRepository,
            SubscriberRepository subscriberRepository,
            DocumentRepository documentRepository) {
        return args -> {
                    Author ana = new Author("ana");
                    Author peter = new Author("peter");
                    Author douglas = new Author("dog");
                    Author joel = new Author("joel");
                    Author brian = new Author("brian");
                    Author dumbledore = new Author("dumbledore");

                    Subscriber karl = new Subscriber("Karl");
                    Subscriber nils = new Subscriber("Nils");
                    Subscriber anna = new Subscriber("Anna");
                    Subscriber malin = new Subscriber("Malin");
                    Subscriber robin = new Subscriber("Robin");

                    Document bible = new Document("bible");
                    Document koran = new Document("koran");
                    Document HP1 = new Document("Harry Potter and The Philosophers Stone");
                    Document HP2 = new Document("Harry Potter and Hermiones Crazy Summer");
                    Document storm = new Document("Storm");
                    Document calm = new Document("Calm");

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
