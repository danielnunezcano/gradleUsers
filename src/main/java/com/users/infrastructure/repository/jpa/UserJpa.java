package com.users.infrastructure.repository.jpa;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "USERS")
public class UserJpa extends AuditingEntityJpa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "USER_ID")
    private Integer id;

    @Column(name = "NAME", nullable = false, unique = true)
    private String name;

    @Column(name = "PASSWORD", nullable = false)
    private String password;

    @Column(name = "BIRTHDATE", nullable = false)
    private LocalDate birthdate;

    @Column(name = "HEIGHT")
    private Double height;

    @Column(name = "WEIGHT")
    private Double weight;

    @Column(name = "BMI")
    private Double bmi;

    public UserJpa() {
    }

    public UserJpa(Integer id, String name, String password, LocalDate birthdate, Double height, Double weight,
                   Double bmi, Date createdDate, String createdUser, Date updatedDate, String updatedUser) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.birthdate = birthdate;
        this.height = height;
        this.bmi = bmi;
        this.weight = weight;
        this.createdDate = createdDate;
        this.createdUser = createdUser;
        this.updatedDate = updatedDate;
        this.updatedUser = updatedUser;
    }

    public Double getBmi() {
        return bmi;
    }

    public void setBmi(Double bmi) {
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
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "UserJpa{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", birthdate=" + birthdate +
                ", height=" + height +
                ", weight=" + weight +
                ", bmi=" + bmi +
                '}';
    }
}