package cacib.bankPayment.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.jms.JmsException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(JmsException.class)
    public ResponseEntity<String> handleJmsException(JmsException ex, WebRequest request) {
        ex.printStackTrace();
        return new ResponseEntity<>("Failed to send message", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGlobalException(Exception ex, WebRequest request) {
        ex.printStackTrace();
        return new ResponseEntity<>("An error occurred", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
