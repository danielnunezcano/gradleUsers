package com.lookiero.infrastructure.dto;

import com.lookiero.domain.model.User;

import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

public class UserRequestDto extends UserDto {

    private String password;

    public UserRequestDto(String name, String password, LocalDate birthdate, Double height, Double weight) {
        super(name, birthdate, height, weight);
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserRequestDto{" +
                "name='" + name + '\'' +
                ", birthdate=" + birthdate +
                ", height=" + height +
                ", weight=" + weight +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserRequestDto user = (UserRequestDto) o;
        return Objects.equals(name, user.name)
                && Objects.equals(birthdate, user.birthdate)
                && Objects.equals(height, user.height)
                && Objects.equals(weight, user.weight);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, birthdate, height, weight);
    }
}
