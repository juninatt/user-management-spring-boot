package iths.not3book.author;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
public class Author {

    private Long id;

    private String userName;

    private Date becameMember;
}
