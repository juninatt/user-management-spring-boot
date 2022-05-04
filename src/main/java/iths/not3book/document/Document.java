package iths.not3book.document;

import com.fasterxml.jackson.annotation.JsonIgnore;
import iths.not3book.author.Author;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PUBLIC, force = true)
@Entity
public class Document {

    @Id
    @SequenceGenerator(
            name = "document_sequence",
            sequenceName = "document_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "document_sequence"
    )
    private Long id;

    @Column(
            nullable = false
    )
    private String title;

    @Column(
            nullable = false
    )
    private Date created = new Date();

    @ManyToMany(mappedBy = "documents")
    @JsonIgnore
    private Set<Author> authors = new HashSet<>();

    public Document(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Document: " +
                "id: " + id +
                ", title: '" + title +
                ", createdAt: " + created +
                ", authors: " + authors +
                "||";
    }
}
