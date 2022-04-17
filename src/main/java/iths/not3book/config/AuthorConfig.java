package iths.not3book.config;

import iths.not3book.author.Author;
import iths.not3book.author.AuthorRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Configuration
public class AuthorConfig {

    @Bean
    CommandLineRunner commandLineRunner(AuthorRepository repository) {
        return args -> {
                    Author ana = new Author("ana");
                    Author peter = new Author("peter");
                    Author douglas = new Author("dog");
                    Author joel = new Author("joel");
                    Author brian = new Author("brian");
                    Author dumbledore = new Author("dumbledore");

            repository.saveAll(
                    List.of(ana, peter, douglas, joel, brian, dumbledore));
        };
    }
}
