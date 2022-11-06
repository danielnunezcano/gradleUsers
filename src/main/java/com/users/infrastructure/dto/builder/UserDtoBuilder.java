package com.users.infrastructure.dto.builder;

import java.time.LocalDate;

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
