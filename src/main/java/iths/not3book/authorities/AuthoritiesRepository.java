package iths.not3book.authorities;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository extending spring data JPA repository.
 * @see org.springframework.data.jpa.repository.JpaRepository
 */
public interface AuthoritiesRepository extends JpaRepository<Authority, Long> {
}
