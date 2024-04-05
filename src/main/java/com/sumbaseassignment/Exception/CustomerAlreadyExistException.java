package com.sumbaseassignment.Exception;

public class CustomerAlreadyExistException extends RuntimeException {
    public CustomerAlreadyExistException(String message){
        super(message);
    }
}
