package iths.not3book.document;

import iths.not3book.author.Author;
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

    public void addDocument(Document document) {
        documentRepository.save(document);
    }

    public void removeDocument(Long documentId) {
        documentRepository.deleteById(documentId);
    }

    @Transactional
    public void updateTitle(Long documentId, String title) {
        Document document = documentRepository.findById(documentId)
                .orElseThrow(() -> new IllegalStateException(
                        "Document with id " + documentId + " does not exist"
                ));
        if ((title != null) && (title.length() > 0)) {
            document.setTitle(title);
        }
    }
}
