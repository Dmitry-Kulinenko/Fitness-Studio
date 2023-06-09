package by.itacademy.fitness.controller;

import by.itacademy.fitness.core.exception.ErrorField;
import by.itacademy.fitness.core.exception.MultipleErrorResponse;
import by.itacademy.fitness.core.exception.SingleErrorResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<MultipleErrorResponse> fieldValidation(MethodArgumentNotValidException e) {
        MultipleErrorResponse errorResponse = new MultipleErrorResponse("structured_error");
        e.getBindingResult()
                .getFieldErrors()
                .forEach(fieldError -> errorResponse.add(new ErrorField(fieldError.getDefaultMessage(),
                        fieldError.getField())));
        return ResponseEntity.badRequest().body(errorResponse);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<SingleErrorResponse> fieldExceptionHandler(IllegalArgumentException e) {
        SingleErrorResponse errorResponse = new SingleErrorResponse("structured_error", e.getLocalizedMessage());
        return ResponseEntity.badRequest().body(errorResponse);
    }

    @ExceptionHandler(Throwable.class)
    public ResponseEntity<SingleErrorResponse> allErrorsHandler(Throwable e) {
        return ResponseEntity.status(500).body(new SingleErrorResponse("server_error", e.getLocalizedMessage()));
    }
}