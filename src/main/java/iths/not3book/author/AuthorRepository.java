package iths.not3book.author;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Author repository extending spring data JPA repository.
 * @see org.springframework.data.jpa.repository.JpaRepository
 */
@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
}
