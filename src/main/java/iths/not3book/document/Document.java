package iths.not3book.document;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
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

    private String title;

    private Date createdAt;
}
