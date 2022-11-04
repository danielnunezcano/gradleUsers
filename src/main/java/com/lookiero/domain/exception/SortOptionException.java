package com.lookiero.domain.exception;

public class SortOptionException extends RuntimeException {

    private static final long serialVersionUID = -1124455913645366682L;

    public SortOptionException() {
        super("This option not exist");
    }
}