package ProjectBackEnd.backend.Model;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;


    @RestControllerAdvice
    public class UserDetailsExceptionHandler {
        @ExceptionHandler(UserDetailsNotExceptionHandler.class)
        @ResponseStatus(HttpStatus.NOT_FOUND)

        String ProfileNotFoundHandler
        (UserDetailsNotFoundException e){
            return e.getMessage();
        }
    
        
    }