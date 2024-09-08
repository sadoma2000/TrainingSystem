package com.Training_System.Api;

public class ApiException extends RuntimeException {

    public ApiException(String message){
        super(message);
    }
}