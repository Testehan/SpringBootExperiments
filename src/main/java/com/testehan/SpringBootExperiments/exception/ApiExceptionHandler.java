package com.testehan.SpringBootExperiments.exception;

// the purpose of this class is to handle custom exceptions or existing exceptions in a custom way that is different from
// the default way that Spring does this.

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.ZonedDateTime;

// this is how we tell Spring that this class is used to handle various exceptions
@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    // THIS is how we tell to Spring that this method will handle exceptions of type ApiRequestException
    @ExceptionHandler(value ={ApiRequestException.class})
    public ResponseEntity<Object> handleApiRequestException(ApiRequestException e){
        //1. create payload containing exception and details
        ApiException apiException = new ApiException(e.getMessage(), e,HttpStatus.BAD_REQUEST, ZonedDateTime.now());
        //2. return reponse entity
        return new ResponseEntity<>(apiException, HttpStatus.BAD_REQUEST);
    }
}
