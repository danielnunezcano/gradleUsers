package com.users.infrastructure.dto.builder;

import com.users.infrastructure.dto.UserRequestDto;

import java.time.LocalDate;

public class UserRequestDtoBuilder extends UserDtoBuilder {

    public UserRequestDtoBuilder name(String name) {
        this.name = name;
        return this;
    }

    public UserRequestDtoBuilder password(String password) {
        this.password = password;
        return this;
    }

    public UserRequestDtoBuilder birthdate(LocalDate BIRTHDATE) {
        this.birthdate = birthdate;
        return this;
    }

    public UserRequestDtoBuilder height(Double height) {
        this.height = height;
        return this;
    }

    public UserRequestDtoBuilder weight(Double weight) {
        this.weight = weight;
        return this;
    }

    public UserRequestDto build() {
        return new UserRequestDto(name, password, birthdate, height, weight);
    }
}
