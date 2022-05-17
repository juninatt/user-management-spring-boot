package iths.not3book.document;

import iths.not3book.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Service class of {@link Document}.
 */
@Service
public class DocumentService {

    private final DocumentRepository documentRepository;

    /**
     * Class constructor.
     * @see DocumentRepository
     */
    @Autowired
    public DocumentService(DocumentRepository documentRepository) {
        this.documentRepository = documentRepository;
    }

    /**
     * Method that return a list of all instances of Document currently stored in database.
     */
    public List<Document> getDocuments() {
        return documentRepository.findAll();
    }

    /**
     *  Method that return Document with matching id.
     */
    public Document getDocument(Long documentId) {
        return documentRepository.findById(documentId)
                .orElseThrow(() -> new ResourceNotFoundException("Document", "id", String.valueOf(documentId)));
    }

    /**
     * Method that saves Document given as parameter to the database.
     */
    public void addDocument(Document document) {
        documentRepository.save(document);
    }

    /**
     * Method that removes Document with matching id from database.
     */
    public void removeDocument(Long documentId) {
        Document document = documentRepository.findById(documentId)
                .orElseThrow(() -> new ResourceNotFoundException("Document", "id", String.valueOf(documentId)));
        documentRepository.delete(document);
    }

    /**
     * Method that updates title of Document  with matching id.
     */
    @Transactional
    public void updateTitle(Long documentId, String title) {
        Document document = documentRepository.findById(documentId)
                .orElseThrow(() -> new ResourceNotFoundException("Document", "id", String.valueOf(documentId)));
        if ((title != null) && (title.length() > 0)) {
            document.setTitle(title);
        }
    }
}
