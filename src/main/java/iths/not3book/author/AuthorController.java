package iths.not3book.author;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/author")
public class AuthorController {

    private final AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    public List<Author> getAuthors() {
        return authorService.getAuthors();
    }

    @PostMapping
    public void addNewAuthor(@RequestBody Author author) {
        authorService.addAuthor(author);
    }
    @DeleteMapping(path = "{authorId}")
    public void removeAuthor(@PathVariable("authorId") Long authorId) {
        authorService.removeAuthor(authorId);
    }
}
