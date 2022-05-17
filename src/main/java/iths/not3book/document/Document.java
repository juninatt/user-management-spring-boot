package iths.not3book.document;

import com.fasterxml.jackson.annotation.JsonIgnore;
import iths.not3book.author.Author;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Document class. Represents the text-files created by the app.
 */
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PUBLIC, force = true)
@Entity
public class Document {

    /**
     * Document id. Increments by one for each new object of the class.
     */
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

    /**
     * Document title. Cannot be null.
     */
    @Column(
            nullable = false
    )
    private String title;

    /**
     * The date when the document is created. Cannot be null.
     */
    @Column(
            nullable = false
    )
    private Date created = new Date();

    /**
     * A set of {@link Author} belonging to the document.
     * Many-to-many relation where Document is the owner.
     */
    @ManyToMany(mappedBy = "documents")
    @JsonIgnore
    private Set<Author> authors = new HashSet<>();

    /**
     * Constructor that takes 'title' as parameter.
     */
    public Document(String title) {
        this.title = title;
    }

    /**
     * Customized toString method.
     */
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
