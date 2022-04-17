package iths.not3book.config;

import iths.not3book.author.Author;
import iths.not3book.author.AuthorRepository;
import iths.not3book.document.Document;
import iths.not3book.document.DocumentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class DocumentConfig {

    @Bean
    CommandLineRunner commandLineRunner(DocumentRepository repository) {
        return args -> {
            Document bible = new Document("bible");
            Document koran = new Document("koran");
            Document HP1 = new Document("Harry Potter and The Philosophers Stone");
            Document HP2 = new Document("Harry Potter and Hermiones Crazy Summer");
            Document storm = new Document("Storm");
            Document calm = new Document("Calm");

            repository.saveAll(
                    List.of(bible, koran, HP1, HP2, storm, calm));
        };
    }
}