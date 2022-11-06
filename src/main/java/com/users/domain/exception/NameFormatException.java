package com.users.domain.exception;

public class NameFormatException extends RuntimeException {

    private static final long serialVersionUID = -1124455913645366682L;

    public NameFormatException() {
        super("Name is not correct format");
    }
}