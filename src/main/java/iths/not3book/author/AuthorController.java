package iths.not3book.author;

import iths.not3book.document.Document;
import iths.not3book.document.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/author")
public class AuthorController {

    private final AuthorService authorService;
    private final DocumentService documentService;

    @Autowired
    public AuthorController(AuthorService authorService, DocumentService documentService) {
        this.authorService = authorService;
        this.documentService = documentService;
    }

    @GetMapping
    public List<Author> getAuthors() {
        return authorService.getAuthors();
    }

    @GetMapping("{authorId}")
    public Author getAuthor(@PathVariable("authorId") Long id) {
        return authorService.getAuthor(id);
    }

    @PostMapping
    public void addNewAuthor(@RequestBody Author author) {
        authorService.addAuthor(author);
    }

    @DeleteMapping(path = "{authorId}")
    public void removeAuthor(@PathVariable("authorId") Long authorId) {
        authorService.removeAuthor(authorId);
    }

    @PutMapping(path = "{authorId}")
    public void updateUserName(
            @PathVariable("authorId") Long authorId,
            @RequestParam String userName) {
       authorService.updateUserName(authorId, userName);
    }
    @PutMapping("{authorId}/document/{documentId}")
    public void addDocumentToAuthor(
            @PathVariable("authorId") Long authorId,
            @PathVariable("documentId") Long documentId
    ) {
      Author author = authorService.getAuthor(authorId);
        Document document = documentService.getDocument(documentId);
        author.addDocument(document);
        authorService.addAuthor(author);
    }
}
