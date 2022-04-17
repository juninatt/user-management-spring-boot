package iths.not3book.subscriber;

import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Service
public class SubscriberService {

    public List<Subscriber> getSubscribers() {
        return List.of(
                new Subscriber(1L, "Sub.ana", Date.valueOf(LocalDate.now())),
                new Subscriber(2L, "Sub.peter", Date.valueOf(LocalDate.now())),
                new Subscriber(3L, "Sub.dog", Date.valueOf(LocalDate.now())),
                new Subscriber(4L, "Sub.joel", Date.valueOf(LocalDate.now())),
                new Subscriber(5L, "Sub.brian", Date.valueOf(LocalDate.now())),
                new Subscriber(6L, "Sub.dumbledore", Date.valueOf(LocalDate.now()))
        );
    }
}
