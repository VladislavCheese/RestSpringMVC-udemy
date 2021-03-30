package com.mvc.rest.exception_handing;

public class NoSuchPeopleException extends RuntimeException{
    public NoSuchPeopleException(String message){
        super(message);
    }
}
