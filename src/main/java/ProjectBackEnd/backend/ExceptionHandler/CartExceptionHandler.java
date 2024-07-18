package ProjectBackEnd.backend.ExceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import ProjectBackEnd.backend.NotFoundException.CartNotFoundException;

@RestControllerAdvice
public class CartExceptionHandler {

    @ExceptionHandler(CartNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String CategoryNotFoundHandler(CartNotFoundException e){
        return e.getMessage();
    }
}
