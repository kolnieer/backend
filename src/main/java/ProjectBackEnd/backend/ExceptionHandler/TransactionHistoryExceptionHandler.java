package ProjectBackEnd.backend.ExceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import ProjectBackEnd.backend.NotFoundException.*;

@RestControllerAdvice
public class TransactionHistoryExceptionHandler {
    
    @ExceptionHandler(TransactionHistoryNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String TransactionHistoryNotFoundHandler(TransactionHistoryNotFoundException e){
        return e.getMessage();
    }
}