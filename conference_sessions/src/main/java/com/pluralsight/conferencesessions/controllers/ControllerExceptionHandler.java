package com.pluralsight.conferencesessions.controllers;

import com.pluralsight.conferencesessions.exceptions.SessionsNotFoundException;
import com.pluralsight.conferencesessions.util.FieldErrorMessage;
import com.pluralsight.conferencesessions.util.SessionsNotFoundResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(SessionsNotFoundException.class)
    public ResponseEntity<SessionsNotFoundResponse> handleSessionNotFoundException(SessionsNotFoundException ex) {
        SessionsNotFoundResponse sessionsNotFoundResponse = new SessionsNotFoundResponse(ex.getMessage());
        return new ResponseEntity(sessionsNotFoundResponse, HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                              HttpHeaders headers, HttpStatus status, WebRequest request) {
        FieldErrorMessage errorDetails = new FieldErrorMessage(
                "Validation Failed",
                ex.getBindingResult().getFieldError().getDefaultMessage());
        System.out.println("erroorrr");
        return new ResponseEntity(errorDetails, HttpStatus.BAD_REQUEST);
    }

}

