package iths.not3book.author;

import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Service
public class AuthorService {

    public List<Author> getAuthors() {
        return List.of(
                new Author(1L, "ana", Date.valueOf(LocalDate.now())),
                new Author(2L, "peter", Date.valueOf(LocalDate.now())),
                new Author(3L, "dog", Date.valueOf(LocalDate.now())),
                new Author(4L, "joel", Date.valueOf(LocalDate.now())),
                new Author(5L, "brian", Date.valueOf(LocalDate.now())),
                new Author(6L, "dumbledore", Date.valueOf(LocalDate.now()))
        );
    }
}
