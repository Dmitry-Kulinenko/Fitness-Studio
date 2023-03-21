package by.itacademy.fitness.controller;

import by.itacademy.fitness.core.exception.ErrorField;
import by.itacademy.fitness.core.exception.MultipleErrorResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<MultipleErrorResponse> fieldValidation(MethodArgumentNotValidException e) {
        MultipleErrorResponse errorResponse = new MultipleErrorResponse("Validation error");
        e.getBindingResult()
                .getFieldErrors()
                .forEach(fieldError -> errorResponse.add(new ErrorField(fieldError.getDefaultMessage(),
                        fieldError.getField())));
        return ResponseEntity.badRequest().body(errorResponse);
    }



//    @ExceptionHandler()
//    public ResponseEntity<SingleErrorResponse> allErrorsHandler(Throwable e) {
//        return ResponseEntity.status(500).body(new SingleErrorResponse("server error", e.getLocalizedMessage()));
//    }
}