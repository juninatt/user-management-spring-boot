package iths.not3book.subscriber;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
public class Subscriber {

    private Long id;

    private String userName;

    private Date becameMember;
}
