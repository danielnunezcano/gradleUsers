package com.lookiero.infrastructure.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lookiero.domain.model.User;

import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

public class UserResponseDto extends UserDto {

    private Integer id;
    private Double bmi;

    public UserResponseDto(Integer id, String name, LocalDate birthdate, Double height, Double weight, Double bmi) {
        super(name, birthdate, height, weight);
        this.id = id;
        this.bmi = bmi;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getBmi() {
        return bmi;
    }

    public void setBmi(Double bmi) {
        this.bmi = bmi;
    }

    @Override
    public String toString() {
        return "UserResponseDto{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", birthdate=" + birthdate +
                ", height=" + height +
                ", weight=" + weight +
                ", bmi=" + bmi +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserResponseDto user = (UserResponseDto) o;
        return Objects.equals(id, user.id)
                && Objects.equals(name, user.name)
                && Objects.equals(birthdate, user.birthdate)
                && Objects.equals(height, user.height)
                && Objects.equals(weight, user.weight)
                && Objects.equals(bmi, user.bmi);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, birthdate, height, weight, bmi);
    }
}
