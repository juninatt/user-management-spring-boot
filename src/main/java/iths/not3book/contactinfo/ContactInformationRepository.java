package iths.not3book.contactinfo;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Contact-information repository extending spring data JPA repository.
 * @see org.springframework.data.jpa.repository.JpaRepository
 */
public interface ContactInformationRepository extends JpaRepository<ContactInformation, Long> {
}
