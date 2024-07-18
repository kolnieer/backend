package ProjectBackEnd.backend.ExceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import ProjectBackEnd.backend.NotFoundException.AddOnsNotFoundException;

@RestControllerAdvice
public class AddOnsExceptionHandler {

    @ExceptionHandler(AddOnsNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String CategoryNotFoundHandler(AddOnsNotFoundException e){
        return e.getMessage();
    }
}
