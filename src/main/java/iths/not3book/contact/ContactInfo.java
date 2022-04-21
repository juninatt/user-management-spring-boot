package iths.not3book.contact;

import iths.not3book.author.Author;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Entity
public class ContactInfo {

    @Id
    @SequenceGenerator(
            name = "contactinfo_sequence",
            sequenceName = "contactinfo_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "contactinfo_sequence"
    )
    private Long id;

    @Column(
            nullable = false
    )
    private String firstName;

    @Column(
            nullable = false
    )
    private String lastName;

    @Column(
            unique = true,
            nullable = false
    )
    private String email;

    @Column(
            unique = true,
            nullable = false
    )
    private String phoneNumber;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "contactInformation")
    @ToString.Exclude
    private Author author;
}
