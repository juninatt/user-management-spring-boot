package iths.not3book.subscriber;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
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

    @Column(
            nullable = false,
            length = 60
    )
    @JsonIgnore
    private String password;

    private String authority;

    @Column(
            nullable = false
    )
    private Date becameMember = new Date();

    public Subscriber(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Subscriber: " +
                "id: " + id +
                ", userName: " + userName +
                ", authority: " + authority +
                ", becameMember: " + becameMember +
                "|||";
    }
}
