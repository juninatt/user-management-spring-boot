package iths.not3book.exception;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ErrorResponse {

    private final int status;
    private final LocalDateTime timeStamp;
    private final String message;
    private final String details;

    public ErrorResponse(int status, LocalDateTime timeStamp, String message, String details) {
        this.status = status;
        this.timeStamp = timeStamp;
        this.message = message;
        this.details = details;
    }
}
