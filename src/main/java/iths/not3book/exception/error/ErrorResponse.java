package iths.not3book.exception.error;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
public class ErrorResponse {

    private final int status;
    private LocalDateTime timeStamp;
    private final String message;
    private String details;

    public ErrorResponse(int status, LocalDateTime timeStamp, String message, String details) {
        this.status = status;
        this.timeStamp = timeStamp;
        this.message = message;
        this.details = details;
    }
}
