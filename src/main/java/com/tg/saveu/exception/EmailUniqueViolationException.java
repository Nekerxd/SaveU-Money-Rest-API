package com.tg.saveu.exception;

public class EmailUniqueViolationException extends RuntimeException {
    public EmailUniqueViolationException(String message) {
        super(message);
    }
}
