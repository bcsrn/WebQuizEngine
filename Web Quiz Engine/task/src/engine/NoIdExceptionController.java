package engine;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class NoIdExceptionController {

    @ExceptionHandler(value = NoIdException.class)
    public ResponseEntity<Object> exception(NoIdException exception){
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
