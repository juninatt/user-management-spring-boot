package iths.not3book.author;

import iths.not3book.contactinfo.ContactInformation;
import iths.not3book.contactinfo.ContactInformationService;
import iths.not3book.document.Document;
import iths.not3book.document.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller for {@link Author}
 */
@RestController
@RequestMapping(path = "/author")
public class AuthorController {

    private final AuthorService authorService;
    private final DocumentService documentService;
    private final ContactInformationService contactInformationService;

    /**
     * Constructor initializing all fields.
     * @see AuthorService
     * @see DocumentService
     * @see ContactInformationService
     */
    @Autowired
    public AuthorController(AuthorService authorService, DocumentService documentService, ContactInformationService contactInformationService) {
        this.authorService = authorService;
        this.documentService = documentService;
        this.contactInformationService = contactInformationService;
    }

    /**
     * Method returning a list of all authors currently stored in database.
     */
    @GetMapping
    public List<Author> getAuthors() {
        return authorService.getAuthors();
    }

    /**
     * Method returning author with matching id.
     */
    @GetMapping("{authorId}")
    public Author getAuthor(@PathVariable("authorId") Long id) {
        return authorService.getAuthor(id);
    }

    /**
     * Method that creates a new author.
     */
    @PostMapping
    public void addNewAuthor(@RequestBody Author author) {
        authorService.addAuthor(author);
    }

    /**
     * Method that removes author with matching id.
     */
    @DeleteMapping(path = "{authorId}")
    public void removeAuthor(@PathVariable("authorId") Long authorId) {
        authorService.removeAuthor(authorId);
    }

    /**
     * Method that updates username of author with matching id.
     */
    @PutMapping(path = "{authorId}")
    public void updateUserName(
            @PathVariable("authorId") Long authorId,
            @RequestParam String userName) {
       authorService.updateUserName(authorId, userName);
    }

    /**
     * Method that adds a document with given id to an author with given id.
     */
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

    /**
     * Method that adds the contactInfo with given id to an author with given id.
     */
    @PutMapping("{authorId}/contactinfo/{contactInfoId}")
    public void addContactInformationToAuthor(
            @PathVariable("authorId") Long authorId,
            @PathVariable("contactInfoId") Long contactInfoId
    ) {
        Author author = authorService.getAuthor(authorId);
        ContactInformation contactInformation = contactInformationService.getContactInformation(contactInfoId);
        author.addContactInformation(contactInformation);
        authorService.addAuthor(author);
    }
}
