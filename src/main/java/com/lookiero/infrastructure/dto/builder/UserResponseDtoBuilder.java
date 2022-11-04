package com.lookiero.infrastructure.dto.builder;

import com.lookiero.infrastructure.dto.UserDto;
import com.lookiero.infrastructure.dto.UserResponseDto;

import java.time.LocalDate;
import java.util.Date;

public class UserResponseDtoBuilder extends UserDtoBuilder {

    private Integer id;
    protected Double bmi;

    public UserResponseDtoBuilder() {
        super();
    }

    public UserResponseDtoBuilder id(Integer id) {
        this.id = id;
        return this;
    }

    public UserResponseDtoBuilder name(String name) {
        this.name = name;
        return this;
    }

    public UserResponseDtoBuilder password(String password) {
        this.password = password;
        return this;
    }

    public UserResponseDtoBuilder birthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
        return this;
    }

    public UserResponseDtoBuilder height(Double height) {
        this.height = height;
        return this;
    }

    public UserResponseDtoBuilder weight(Double weight) {
        this.weight = weight;
        return this;
    }

    public UserResponseDtoBuilder bmi(Double bmi) {
        this.bmi = bmi;
        return this;
    }

    public UserResponseDto build() {
        return new UserResponseDto(id, name, birthdate, height, weight, bmi);
    }
}
