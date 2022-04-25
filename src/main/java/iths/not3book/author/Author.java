package iths.not3book.author;

import com.fasterxml.jackson.annotation.JsonIgnore;
import iths.not3book.contactinfo.ContactInfo;
import iths.not3book.document.Document;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString
@NoArgsConstructor(access = AccessLevel.PUBLIC, force = true)
@Entity
public class Author {

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

    @Column(
            unique = true,
            nullable = false
    )
    private String userName;


    private Date becameMember = new Date();

    @ManyToMany
    @JoinTable(
            name = "author_document_table",
            joinColumns = @JoinColumn(name = "author_id"),
            inverseJoinColumns = @JoinColumn(name = "document_id")
    )
    @JsonIgnore
    @ToString.Exclude
    private Set<Document> documents = new HashSet<>();

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "contact_info_id")
    @JsonIgnore
    @ToString.Exclude
    private ContactInfo contactInformation;

    public Author(String userName) {
        this.userName = userName;
    }

    public void addDocument(Document document) {
        documents.add(document);
    }

    public void addContactInformation(ContactInfo contactInfo) {
        this.contactInformation = contactInfo;
    }
}