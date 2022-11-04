package com.lookiero.domain.exception;

public class HeightException extends RuntimeException {

    private static final long serialVersionUID = -1124455913645366682L;

    public HeightException(final Double height) {
        super("The height ".concat(height.toString()).concat(" is outside the range"));
    }
}