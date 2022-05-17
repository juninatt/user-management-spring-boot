package iths.not3book.author;

import com.fasterxml.jackson.annotation.JsonIgnore;
import iths.not3book.contactinfo.ContactInformation;
import iths.not3book.document.Document;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Author class. Currently, the main user class.
 */
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PUBLIC, force = true)
@Entity
public class Author {

    /**
     * Author id. Increments by one for each new object of the class.
     */
    @Id
    @SequenceGenerator(
            name = "author_sequence",
            sequenceName = "author_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "author_sequence"
    )
    private Long id;

    /**
     * Author username. Has to be a unique value and can't be null.
     */
    @Column(
            unique = true,
            nullable = false
    )
    private String userName;

    /**
     * Author password, stored with author for testing purposes.
     * Cannot be null and maxlength 60 characters.
     */
    @Column(
            nullable = false,
            length = 60
    )
    @JsonIgnore
    private String password;

    /**
     * Tells if the author is active as a user.
     */
    @Column(
            nullable = false
    )
    @JsonIgnore
    private int enabled;

    /**
     * The date when the user was registered as an author.
     */
    private Date becameMember;

    /**
     * A set of {@link Document} belonging to the author.
     * Many-to-many relationship where Document is the owner.
     */
    @ManyToMany
    @JoinTable(
            name = "author_document_table",
            joinColumns = @JoinColumn(name = "author_id"),
            inverseJoinColumns = @JoinColumn(name = "document_id")
    )
    @JsonIgnore
    private Set<Document> documents = new HashSet<>();

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "contact_info_id")
    @JsonIgnore
    private ContactInformation contactInformation;

    public Author(String userName, String password, int enabled) {
        this.userName = userName;
        this.password = password;
        this.enabled = enabled;
    }

    /**
     * Adds a {@link Document} to the set of documents belonging to the author.
     */
    public void addDocument(Document document) {
        documents.add(document);
    }

    /**
     * Adds {@link ContactInformation} to the author.
     */
    public void addContactInformation(ContactInformation contactInformation) {
        this.contactInformation = contactInformation;
    }

    /**
     * Customized toString method.
     */
    @Override
    public String toString() {
        return "Author " +
                "id:" + id +
                ", userName: " + userName +
                ", enabled: " + enabled +
                ", becameMember: " + becameMember +
                "|||";
    }
}