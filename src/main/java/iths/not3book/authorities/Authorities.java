package iths.not3book.authorities;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@NoArgsConstructor(access = AccessLevel.PUBLIC, force = true)
@Entity
public class Authorities {


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

    @Column(
            nullable = false
    )
    private String userName;

    @Column(
            nullable = false
    )
    private String authority;

    public Authorities(String userName, String authority) {
        this.userName = userName;
        this.authority = authority;
    }
}
