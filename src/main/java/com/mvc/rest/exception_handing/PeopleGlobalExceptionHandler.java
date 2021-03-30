package com.mvc.rest.exception_handing;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class PeopleGlobalExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<PeopleIncorrectData> handleException(NoSuchPeopleException exc){
        PeopleIncorrectData incorrectData = new PeopleIncorrectData();
        incorrectData.setInfo(exc.getMessage());
        return new ResponseEntity<>(incorrectData, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler
    public ResponseEntity<PeopleIncorrectData> handleException(Exception exc){
        PeopleIncorrectData incorrectData = new PeopleIncorrectData();
        incorrectData.setInfo(exc.getMessage());
        return new ResponseEntity<>(incorrectData, HttpStatus.BAD_REQUEST);
    }
}
