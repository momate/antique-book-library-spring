package com.momate.antiquebooklibraryspring.exception;

public class UserNotFoundException extends RuntimeException{

    public UserNotFoundException(String s) {
        super(s);
    }
}
