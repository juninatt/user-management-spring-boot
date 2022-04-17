package iths.not3book.config;

import iths.not3book.document.DocumentRepository;
import iths.not3book.subscriber.Subscriber;
import iths.not3book.subscriber.SubscriberRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SubscriberConfig {

    @Bean
    CommandLineRunner commandLineRunner(SubscriberRepository repository) {
        return args -> {
            Subscriber karl = new Subscriber("Karl");
            Subscriber nils = new Subscriber("Nils");
            Subscriber anna = new Subscriber("Anna");
            Subscriber malin = new Subscriber("Malin");
            Subscriber robin = new Subscriber("Robin");


            repository.saveAll(
                    List.of(karl, nils, anna, malin, robin));
        };
    }
}
