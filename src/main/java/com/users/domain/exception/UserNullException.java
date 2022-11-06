package com.users.domain.exception;

public class UserNullException extends RuntimeException {

    private static final long serialVersionUID = -1124455913645366682L;

    public UserNullException() {
        super("User Name is null");
    }
}