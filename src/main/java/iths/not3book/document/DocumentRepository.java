package iths.not3book.document;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Document repository extending spring data JPA repository.
 * @see org.springframework.data.jpa.repository.JpaRepository
 */
@Repository
public interface DocumentRepository extends JpaRepository<Document, Long> {
}
