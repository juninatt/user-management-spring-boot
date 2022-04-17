package iths.not3book.document;

import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Service
public class DocumentService {

    public List<Document> getDocuments() {
        return List.of(
                new Document(1L, "The Bible", Date.valueOf(LocalDate.now())),
                new Document(2L, "The Koran", Date.valueOf(LocalDate.now())),
                new Document(3L, "Around the World in 80 Days", Date.valueOf(LocalDate.now())),
                new Document(4L, "Under the Wings of a Raven", Date.valueOf(LocalDate.now())),
                new Document(5L, "Harry Potter and the Goblet of Fire", Date.valueOf(LocalDate.now())),
                new Document(6L, "Storm", Date.valueOf(LocalDate.now()))
        );
    }
}
