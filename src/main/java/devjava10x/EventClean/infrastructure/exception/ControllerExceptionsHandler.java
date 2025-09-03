package devjava10x.EventClean.infrastructure.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ControllerExceptionsHandler  {

    @ExceptionHandler(DuplicateEventException.class)
    public ResponseEntity<Map<String,String>> handleDuplicateEventsExceptions(DuplicateEventException exc){

        Map<String, String> response = new HashMap<>();
        response.put("Error: ", exc.getMessage());
        response.put("Message: ", "Por favor insira o ID valido para o seu evento e tente novamente");

        return new ResponseEntity<>(response, HttpStatus.CONFLICT);



    }

}
