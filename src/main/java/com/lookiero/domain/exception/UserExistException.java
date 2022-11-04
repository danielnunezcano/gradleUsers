package com.lookiero.domain.exception;

import java.util.Objects;

public class UserExistException extends RuntimeException {

    private static final long serialVersionUID = -1124455913645366682L;

    public UserExistException(final String object) {
        super(object.concat(" exist"));
    }
}