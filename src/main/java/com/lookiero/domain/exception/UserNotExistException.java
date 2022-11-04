package com.lookiero.domain.exception;

public class UserNotExistException extends RuntimeException {

    private static final long serialVersionUID = -1124455913645366682L;

    public UserNotExistException(final Integer object) {
        super(object.toString().concat(" not exist"));
    }
}