package iths.not3book.subscriber;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@ToString
@NoArgsConstructor(access = AccessLevel.PUBLIC, force = true)
@Entity
public class Subscriber {

    @Id
    @SequenceGenerator(
            name = "subscriber_sequence",
            sequenceName = "subscriber_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "subscriber_sequence"
    )
    private Long id;

    @Column(
            unique = true,
            nullable = false
    )
    private String userName;

    private Date becameMember;

    public Subscriber(String userName) {
        this.userName = userName;
    }
}
