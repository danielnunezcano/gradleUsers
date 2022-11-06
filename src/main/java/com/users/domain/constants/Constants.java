package com.users.domain.constants;

public class Constants {

    private Double heightLess;
    private Double heightOver;
    private Double weightLess;
    private Double weightOver;
    private String nameRegex;

    public Constants(Double heightLess, Double heightOver, Double weightLess, Double weightOver, String nameRegex) {
        this.heightLess = heightLess;
        this.heightOver = heightOver;
        this.weightLess = weightLess;
        this.weightOver = weightOver;
        this.nameRegex = nameRegex;
    }

    public Double getHeightLess() {
        return heightLess;
    }

    public Double getHeightOver() {
        return heightOver;
    }

    public Double getWeightLess() {
        return weightLess;
    }

    public Double getWeightOver() {
        return weightOver;
    }

    public String getNameRegex() {
        return nameRegex;
    }
}
