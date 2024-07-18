package tv.alphanetworks.training.video_store.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(CustomerExceptions.class)
    public ResponseEntity<Object> handleCustomerAlreadyExistsException(
            CustomerExceptions ex, WebRequest request) {

        ErrorMessage errorMessage = new ErrorMessage(
                LocalDateTime.now(),
                HttpStatus.CONFLICT.value(), // 409 Conflict
                "Customer Already Exists",
                ex.getMessage(),
                request.getDescription(false));

        return ResponseEntity.status(HttpStatus.CONFLICT).body(errorMessage);
    }

    // Generic exception handler
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleGenericException(
            Exception ex, WebRequest request) {

        ErrorMessage errorMessage = new ErrorMessage(
                LocalDateTime.now(),
                HttpStatus.INTERNAL_SERVER_ERROR.value(), // 500 Internal Server Error
                "Internal Server Error",
                ex.getMessage(),
                request.getDescription(false));

        return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    // Define ErrorMessage class for consistent error responses
    static class ErrorMessage {
        private LocalDateTime timestamp;
        private int status;
        private String error;
        private String message;
        private String path;


        public ErrorMessage(LocalDateTime now, int value, String internal_server_error, String message, String description) {
            this.timestamp=now;
            this.status=value;
            this.error=internal_server_error;
            this.message=message;
            this.path=description;
        }
    }
}