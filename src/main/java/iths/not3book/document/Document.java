package iths.not3book.document;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
public class Document {

    private Long id;

    private String title;

    private Date createdAt;
}
