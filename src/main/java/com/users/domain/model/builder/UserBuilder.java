package com.users.domain.model.builder;

import com.users.domain.model.User;

import java.time.LocalDate;

public class UserBuilder {

    private Integer id;
    private String name;
    private String password;
    private LocalDate birthdate;
    private Double height;
    private Double weight;
    private Double bmi;

    public UserBuilder() {
        super();
    }

    public UserBuilder id(Integer id) {
        this.id = id;
        return this;
    }

    public UserBuilder name(String name) {
        this.name = name;
        return this;
    }

    public UserBuilder password(String password) {
        this.password = password;
        return this;
    }

    public UserBuilder birthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
        return this;
    }

    public UserBuilder height(Double height) {
        this.height = height;
        return this;
    }

    public UserBuilder weight(Double weight) {
        this.weight = weight;
        return this;
    }

    public UserBuilder bmi(Double bmi) {
        this.bmi = bmi;
        return this;
    }

    public User build() {
        return new User(id, name, password, birthdate, height, weight, bmi);
    }
}
