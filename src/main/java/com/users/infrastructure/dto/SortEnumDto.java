package com.users.infrastructure.dto;

public enum SortEnumDto {

    BIRTHDAY(1),

    BMI(2);

    private final Integer value;

    SortEnumDto(final Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

}
