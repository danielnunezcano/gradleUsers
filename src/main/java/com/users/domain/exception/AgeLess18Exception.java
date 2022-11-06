package com.users.domain.exception;

public class AgeLess18Exception extends RuntimeException {

    private static final long serialVersionUID = -1124455913645366682L;

    public AgeLess18Exception() {
        super("Age is less than 18 years old");
    }
}