package com.lookiero.domain.exception;

public class PasswordNullException extends RuntimeException {

    private static final long serialVersionUID = -1124455913645366682L;

    public PasswordNullException() {
        super("Password is null");
    }
}