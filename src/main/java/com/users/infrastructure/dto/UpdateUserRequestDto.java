package com.users.infrastructure.dto;

public class UpdateUserRequestDto {

    private Double height;
    private Double weight;

    public UpdateUserRequestDto(Double height, Double weight) {
        this.height = height;
        this.weight = weight;
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
