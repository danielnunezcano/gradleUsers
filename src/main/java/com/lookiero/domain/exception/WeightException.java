package com.lookiero.domain.exception;

public class WeightException extends RuntimeException {

    private static final long serialVersionUID = -1124455913645366682L;

    public WeightException(final Double height) {
        super("The weight ".concat(height.toString()).concat(" is outside the range"));
    }
}