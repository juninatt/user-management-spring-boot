package iths.not3book.author;

import iths.not3book.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public List<Author> getAuthors() {
        return authorRepository.findAll();
    }

    public Author getAuthor(Long authorId) {
        return authorRepository.findById(authorId)
                .orElseThrow(() -> new ResourceNotFoundException("Author", "id", authorId));
    }

    public void addAuthor(Author author) {
        authorRepository.save(author);
    }

    public void removeAuthor(Long authorId) {
        Author author = authorRepository.findById(authorId)
                        .orElseThrow(() -> new ResourceNotFoundException("Author", "id", authorId));
        authorRepository.delete(author);
    }

    @Transactional
    public void updateUserName(Long authorId, String userName) {
        Author author = authorRepository.findById(authorId)
                .orElseThrow(() -> new ResourceNotFoundException("Author", "id", authorId)
        );
        if ((userName != null) && (userName.length() > 0)) {
            author.setUserName(userName);
        }
    }
}
