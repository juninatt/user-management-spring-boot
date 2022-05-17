package iths.not3book.document;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller for {@link Document}
 */
@RestController
@RequestMapping(path = "/document")
public class DocumentController {

    private final DocumentService documentService;

    /**
     * Constructor initializing only field.
     * @see DocumentService
     */
    @Autowired
    public DocumentController(DocumentService documentService) {
        this.documentService = documentService;
    }

    /**
     * Method that returns all documents currently stored in database.
     */
    @GetMapping
    public List<Document> getDocuments() {
        return documentService.getDocuments();
    }

    /**
     * Method that returns document with matching id.
     */
    @GetMapping(path = ("{documentId}"))
    public Document getDocument(@PathVariable("documentId") Long documentId) {
        return documentService.getDocument(documentId);
    }

    /**
     * Method that creates a new document.
     */
    @PostMapping
    public void addNewDocument(@RequestBody Document document) {
        documentService.addDocument(document);
    }

    /**
     * Method that removes document with matching id.
     */
    @DeleteMapping(path = "{documentId}")
    public void removeDocument(@PathVariable("documentId") Long documentId) {
        documentService.removeDocument(documentId);
    }

    /**
     * Method that updates title of document with matching id.
     */
    @PutMapping(path = "{documentId}")
    public void updateTitle(
            @PathVariable("documentId") Long documentId,
            @RequestParam String title) {
        documentService.updateTitle(documentId, title);
    }
}
