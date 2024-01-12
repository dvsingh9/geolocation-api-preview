package com.geolocation.globe.geolocationapi.rest.validations;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
@RestController
@Configuration
public class GlobalExceptionHandler {

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public ErrorResponse handleException(MethodArgumentNotValidException e) {
        List<Error> errors = processErrors(e);
        return ErrorResponse
                .builder()
                .errors(errors)
                .errorMessage(e.getMessage())
                .build();
    }

    private List<Error> processErrors(MethodArgumentNotValidException e) {
        List<Error> validationErrors = new ArrayList<Error>();
        for (FieldError fieldError : e.getBindingResult().getFieldErrors()) {
            Error validationError = Error
                    .builder()
                    .code(fieldError.getCode())
                    .field(fieldError.getField())
                    .source(fieldError.getObjectName() + "/" + fieldError.getField())
                    .detail(fieldError.getField() + " " + fieldError.getDefaultMessage())
                    .build();
            validationErrors.add(validationError);
        }
        return validationErrors;
    }
}
