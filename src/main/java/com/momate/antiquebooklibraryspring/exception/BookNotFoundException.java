package com.momate.antiquebooklibraryspring.exception;

public class BookNotFoundException extends RuntimeException {

    public BookNotFoundException(String s) {
        super(s);
    }
}
