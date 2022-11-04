package com.lookiero.infrastructure.dto.builder;

import com.lookiero.infrastructure.dto.UserResponseDto;

import java.time.LocalDate;
import java.util.Date;

public abstract class UserDtoBuilder {

    protected String name;
    protected String password;
    protected LocalDate birthdate;
    protected Double height;
    protected Double weight;

    protected UserDtoBuilder() {
        super();
    }

}
