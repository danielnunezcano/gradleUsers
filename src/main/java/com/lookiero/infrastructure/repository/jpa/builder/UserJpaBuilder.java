package com.lookiero.infrastructure.repository.jpa.builder;

import com.lookiero.domain.model.User;
import com.lookiero.infrastructure.repository.jpa.UserJpa;
import org.springframework.data.annotation.CreatedBy;

import javax.persistence.Column;
import java.time.LocalDate;
import java.util.Date;

public class UserJpaBuilder {

    private Integer id;
    private String name;
    private String password;
    private LocalDate birthdate;
    private Double height;
    private Double weight;
    private Double bmi;
    private Date createdDate;
    private String createdUser;
    private Date updatedDate;
    private String updatedUser;

    public UserJpaBuilder() {
        super();
    }

    public UserJpaBuilder id(Integer id) {
        this.id = id;
        return this;
    }

    public UserJpaBuilder name(String name) {
        this.name = name;
        return this;
    }

    public UserJpaBuilder password(String password) {
        this.password = password;
        return this;
    }

    public UserJpaBuilder birthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
        return this;
    }

    public UserJpaBuilder height(Double height) {
        this.height = height;
        return this;
    }

    public UserJpaBuilder weight(Double weight) {
        this.weight = weight;
        return this;
    }

    public UserJpaBuilder bmi(Double bmi) {
        this.bmi = bmi;
        return this;
    }

    public UserJpaBuilder createdDate(Date createdDate) {
        this.createdDate = createdDate;
        return this;
    }

    public UserJpaBuilder createdUser(String createdUser) {
        this.createdUser = createdUser;
        return this;
    }

    public UserJpaBuilder updatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
        return this;
    }

    public UserJpaBuilder updatedUser(String updatedUser) {
        this.updatedUser = updatedUser;
        return this;
    }


    public UserJpa build() {
        return new UserJpa(id, name, password, birthdate, height, weight, bmi, createdDate, createdUser, updatedDate,
                updatedUser);
    }
}
