package iths.not3book.document;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocumentService {

    private final DocumentRepository documentRepository;

    @Autowired
    public DocumentService(DocumentRepository documentRepository) {
        this.documentRepository = documentRepository;
    }
    public List<Document> getDocuments() {
        return documentRepository.findAll();
    }

    public void addDocument(Document document) {
        documentRepository.save(document);
    }
}
