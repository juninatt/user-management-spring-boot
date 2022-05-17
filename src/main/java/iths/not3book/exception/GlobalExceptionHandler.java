package iths.not3book.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

/**
 * GlobalExceptionHandler class with ControllerAdvice annotation.
 * Provides centralized exception handling across all methods
 * subject to the RequestMapping-annotation.
 * @see ResponseEntityExceptionHandler
 */
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {


    /**
     * Method that handles the logic for {@link org.springframework.web.client.HttpServerErrorException.InternalServerError}.
     * @param exception The exception that was thrown.
     * @param webRequest The request made that led to the exception being thrown.
     * @see ErrorResponse
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<ErrorResponse> handleInternalErrorException(Exception exception,
                                                                      WebRequest webRequest){
        HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        ErrorResponse errorResponse = new ErrorResponse(
                httpStatus.value(),
                LocalDateTime.now(),
                exception.getMessage(),
                webRequest.getDescription(false));
        return new ResponseEntity<>(errorResponse, httpStatus);
    }


    /**
     * Method that handles the logic for {@link ResourceNotFoundException}.
     * @param exception The exception that was thrown
     * @param webRequest The request made that led to the exception being thrown.
     * @see ErrorResponse
     */
    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ErrorResponse> handleResourceNotFoundException(ResourceNotFoundException exception,
                                                                         WebRequest webRequest){
        HttpStatus httpStatus = HttpStatus.NOT_FOUND;
        ErrorResponse errorDetails = new ErrorResponse(
                httpStatus.value(),
                LocalDateTime.now(),
                exception.getMessage(),
                webRequest.getDescription(false));
        return new ResponseEntity<>(errorDetails, httpStatus);
    }
}
