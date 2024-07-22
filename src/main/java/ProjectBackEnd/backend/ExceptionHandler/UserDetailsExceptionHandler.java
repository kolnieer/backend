package ProjectBackEnd.backend.ExceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import ProjectBackEnd.backend.NotFoundException.UserDetailsNotFoundException;



    @RestControllerAdvice
    public class UserDetailsExceptionHandler {
        @ExceptionHandler(UserDetailsNotFoundException.class)
        @ResponseStatus(HttpStatus.NOT_FOUND)

        String ProfileNotFoundHandler
        (UserDetailsNotFoundException e){
            return e.getMessage();
        }
    
        
    }