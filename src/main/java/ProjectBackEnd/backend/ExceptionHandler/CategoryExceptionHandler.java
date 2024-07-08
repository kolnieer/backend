package ProjectBackEnd.backend.ExceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import ProjectBackEnd.backend.NotFoundException.CategoryNotFoundException;

@RestControllerAdvice
public class CategoryExceptionHandler {

    @ExceptionHandler(CategoryNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String CategoryNotFoundHandler(CategoryNotFoundException e){
        return e.getMessage();
    }
}
