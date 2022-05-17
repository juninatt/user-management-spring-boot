package iths.not3book.exception;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * The class that holds the information shown to the user when exception is thrown.
 */
@Getter
@Setter
public class ErrorResponse {

    private final int status;
    private final LocalDateTime timeStamp;
    private final String message;
    private final String details;

    /**
     * Class constructor initializing all fields.
     * @param status Should be given appropriate status code to describe the error.
     * @param timeStamp Time when the exception was thrown.
     * @param message Message that describes the error.
     * @param details Further details about what went wrong or link to documentation etc.
     */
    public ErrorResponse(int status, LocalDateTime timeStamp, String message, String details) {
        this.status = status;
        this.timeStamp = timeStamp;
        this.message = message;
        this.details = details;
    }
}
