package iths.not3book.document;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/document")
public class DocumentController {

    private final DocumentService documentService;

    @Autowired
    public DocumentController(DocumentService documentService) {
        this.documentService = documentService;
    }

    @GetMapping
    public List<Document> getDocuments() {
        return documentService.getDocuments();
    }

    @GetMapping(path = ("{documentId}"))
    public Document getDocument(@PathVariable("documentId") Long documentId) {
        return documentService.getDocument(documentId);
    }

    @PostMapping
    public void addNewDocument(@RequestBody Document document) {
        documentService.addDocument(document);
    }

    @DeleteMapping(path = "{documentId}")
    public void removeDocument(@PathVariable("documentId") Long documentId) {
        documentService.removeDocument(documentId);
    }

    @PutMapping(path = "{documentId}")
    public void updateTitle(
            @PathVariable("documentId") Long documentId,
            @RequestParam String title) {
        documentService.updateTitle(documentId, title);
    }
}
