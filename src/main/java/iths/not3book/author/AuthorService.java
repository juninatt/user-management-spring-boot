package iths.not3book.author;

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

    public void addAuthor(Author author) {
        authorRepository.save(author);
    }

    public void removeAuthor(Long authorId) {
        authorRepository.deleteById(authorId);
    }

    @Transactional
    public void updateUserName(Long authorId, String userName) {
        Author author = authorRepository.findById(authorId)
                .orElseThrow(() -> new IllegalStateException(
           "Author with id " + authorId + " does not exist"
        ));
        if ((userName != null) && (userName.length() > 0)) {
            author.setUserName(userName);
        }
    }
}
