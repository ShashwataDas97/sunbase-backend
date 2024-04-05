package com.sumbaseassignment.Exception;

public class CustomerDoesNotExistException extends RuntimeException{
    public CustomerDoesNotExistException(String message){
        super(message);
    }
}
