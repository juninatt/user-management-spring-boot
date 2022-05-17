package iths.not3book.authorities;

import lombok.*;

import javax.persistence.*;

/**
 * Authorities class that represents what the user is allowed to do in the application.
 */
@Getter
@Setter
@ToString
@NoArgsConstructor(access = AccessLevel.PUBLIC, force = true)
@Entity
public class Authority {


    /**
     * Authorities id. Increments by one for each new object of the class.
     */
    @Id
    @SequenceGenerator(
            name = "authorities_sequence",
            sequenceName = "authorities_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "authorities_sequence"
    )
    private Long id;

    /**
     * Username of the user given the authority. Cannot be null.
     */
    @Column(
            nullable = false
    )
    private String userName;

    /**
     * Name of the authority given. Cannot be null.
     */
    @Column(
            nullable = false
    )
    private String authority;

    /**
     * Constructor that takes both fields as parameters.
     */
    public Authority(String userName, String authority) {
        this.userName = userName;
        this.authority = authority;
    }
}
