package iths.not3book.document;

import iths.not3book.author.Author;
import iths.not3book.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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

    public Document getDocument(Long documentId) {
        return documentRepository.findById(documentId)
                .orElseThrow(() -> new ResourceNotFoundException("Document", "id", documentId));
    }

    public void addDocument(Document document) {
        documentRepository.save(document);
    }

    public void removeDocument(Long documentId) {
        Document document = documentRepository.findById(documentId)
                .orElseThrow(() -> new ResourceNotFoundException("Document", "id", documentId));
        documentRepository.delete(document);
    }

    @Transactional
    public void updateTitle(Long documentId, String title) {
        Document document = documentRepository.findById(documentId)
                .orElseThrow(() -> new ResourceNotFoundException("Document", "id", documentId));
        if ((title != null) && (title.length() > 0)) {
            document.setTitle(title);
        }
    }
}
