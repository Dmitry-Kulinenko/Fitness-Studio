package by.itacademy.fitness.core.exception;


import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.ArrayList;
import java.util.List;

@JsonPropertyOrder({
        "logref",
        "errors"})
public class MultipleErrorResponse {
    private String logref;
    List<ErrorField> errors;

    public MultipleErrorResponse(String logref) {
        this.logref = logref;
        errors = new ArrayList<>();
    }

    public MultipleErrorResponse(String logref, List<ErrorField> errors) {
        this.logref = logref;
        this.errors = errors;
    }

    public void setLogref(String logref) {
        this.logref = logref;
    }

    public String getLogref() {
        return logref;
    }

    public List<ErrorField> getErrors() {
        return errors;
    }

    public void add(ErrorField error) {
        errors.add(error);
    }
}
