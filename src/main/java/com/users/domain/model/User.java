package com.users.domain.model;

import java.time.LocalDate;
import java.util.Objects;

public class User {
    private Integer id;
    private String name;
    private String password;
    private LocalDate birthdate;
    private Double height;
    private Double weight;
    private Double bmi;

    public User(final Integer id, final String name, final String password,
                final LocalDate birthdate, final Double height, final Double weight, final Double bmi) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.birthdate = birthdate;
        this.height = height;
        this.weight = weight;
        this.bmi = bmi;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
        updateBmi();
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
        updateBmi();
    }

    public Double getBmi() {
        return bmi;
    }

    public void setBirthdate(Double bmi) {
        this.bmi = bmi;
    }

    public void updateBmi() {
        if (this.height != null && this.weight != null) {
            this.bmi = this.weight / (this.height * this.height);
        }
    }

    public void updateHeightWeightUser(final User updateUser) {
        this.height = updateUser.getHeight() != null ? updateUser.getHeight() : this.height;
        this.weight = updateUser.getWeight() != null ? updateUser.getWeight() : this.weight;
        updateBmi();
    }


    @Override
    public String toString() {
        return "User{" +
                ", id='" + id + '\'' +
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
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(name, user.name)
                && Objects.equals(birthdate, user.birthdate)
                && Objects.equals(height, user.height) && Objects.equals(weight, user.weight);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, birthdate, height, weight);
    }
}
