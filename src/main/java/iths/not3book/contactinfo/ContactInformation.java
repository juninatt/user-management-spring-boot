package iths.not3book.contactinfo;

import iths.not3book.author.Author;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

/**
 *The Contact-Information class. Contains the contact information of users.
 */
@Getter
@Setter
@ToString
@Entity
public class ContactInformation {

    /**
     * Contact-Information id. Increments by one for each new object of the class.
     */
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

    /**
     * User first name. Cannot be null.
     */
    @Column(
            nullable = false
    )
    private String firstName;

    /**
     * User last name. Cannot be null.
     */
    @Column(
            nullable = false
    )
    private String lastName;

    /**
     * User email. Has to be a unique value and cannot be null.
     */
    @Column(
            unique = true,
            nullable = false
    )
    private String email;

    /**
     * User phone-number. Has to be a unique value and cannot be null.
     */
    @Column(
            unique = true,
            nullable = false
    )
    private String phoneNumber;

    /**
     * The author the contact-information is regarding.
     * One-to-one relationship where ContactInformation is the owner.
     */
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "contactInformation")
    @ToString.Exclude
    private Author author;
}
