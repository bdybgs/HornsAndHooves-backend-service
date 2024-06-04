package com.example.demo.exceprion;

public class UserAlereadyExistException extends Exception{
    public UserAlereadyExistException(String message) {
        super(message);
    }
}
