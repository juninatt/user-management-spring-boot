package iths.not3book.author;

import iths.not3book.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Service class of {@link Author}.
 */
@Service
public class AuthorService {

    private final AuthorRepository authorRepository;

    /**
     * Class constructor.
     * @see AuthorRepository
     */
    @Autowired
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    /**
     * Method that returns a list of all instances of Author currently stored in the database.
     */
    public List<Author> getAuthors() {
        return authorRepository.findAll();
    }

    /**
     * Method that returns Author with matching id.
     */
    public Author getAuthor(Long authorId) {
        return authorRepository.findById(authorId)
                .orElseThrow(() -> new ResourceNotFoundException("Author", "id", String.valueOf(authorId)));
    }

    /**
     * Method that saves the Author given as parameter to the database.
     */
    public void addAuthor(Author author) {
        authorRepository.save(author);
    }

    /**
     * Method that removes Author with matching id from database.
     */
    public void removeAuthor(Long authorId) {
        Author author = authorRepository.findById(authorId)
                        .orElseThrow(() -> new ResourceNotFoundException("Author", "id", String.valueOf(authorId)));
        authorRepository.delete(author);
    }

    /**
     *  Method that updates username of Author with matching id.
     */
    @Transactional
    public void updateUserName(Long authorId, String userName) {
        Author author = authorRepository.findById(authorId)
                .orElseThrow(() -> new ResourceNotFoundException("Author", "id", String.valueOf(authorId)));
        if ((userName != null) && (userName.length() > 0)) {
            author.setUserName(userName);
        }
    }
}
