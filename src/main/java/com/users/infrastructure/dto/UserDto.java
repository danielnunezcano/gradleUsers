package com.users.infrastructure.dto;

import java.time.LocalDate;

public abstract class UserDto {

    protected String name;
    protected LocalDate birthdate;
    protected Double height;
    protected Double weight;

    protected UserDto(String name, LocalDate birthdate, Double height, Double weight) {
        this.name = name;
        this.birthdate = birthdate;
        this.height = height;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

}
