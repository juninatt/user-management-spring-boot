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
    @PostMapping
    public void registerDocument(@RequestBody Document document) {
        documentService.addDocument(document);
    }
}
