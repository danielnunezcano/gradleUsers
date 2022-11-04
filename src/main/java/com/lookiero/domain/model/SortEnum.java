package com.lookiero.domain.model;

import com.lookiero.domain.exception.SortOptionException;

public enum SortEnum {

    BIRTHDAY(1),

    BMI(2);

    private final Integer value;

    SortEnum(final Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    public static SortEnum integerToSortEnum(final Integer input) {
        for (final SortEnum b : SortEnum.values()) {
            if (b.value == input) {
                return b;
            }
        }
        throw new SortOptionException();
    }
}
