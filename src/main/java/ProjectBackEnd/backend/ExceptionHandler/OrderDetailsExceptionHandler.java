package ProjectBackEnd.backend.ExceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import ProjectBackEnd.backend.NotFoundException.OrderDetailsNotFoundException;

@RestControllerAdvice
public class OrderDetailsExceptionHandler {

    @ExceptionHandler(OrderDetailsNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String OrderNotFoundHandler(OrderDetailsNotFoundException e) {
        return e.getMessage();
    }

}
