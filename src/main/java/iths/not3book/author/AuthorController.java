package iths.not3book.author;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path = "/author")
public class AuthorController {

    @GetMapping("/test")
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
