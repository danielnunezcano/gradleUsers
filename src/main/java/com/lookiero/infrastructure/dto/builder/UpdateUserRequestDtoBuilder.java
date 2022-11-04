package com.lookiero.infrastructure.dto.builder;

import com.lookiero.infrastructure.dto.UpdateUserRequestDto;
import com.lookiero.infrastructure.dto.UserResponseDto;

import java.util.Date;

public class UpdateUserRequestDtoBuilder extends UserDtoBuilder {

    private Double height;
    private Double weight;

    public UpdateUserRequestDtoBuilder() {
        super();
    }

    public UpdateUserRequestDtoBuilder height(Double height) {
        this.height = height;
        return this;
    }

    public UpdateUserRequestDtoBuilder weight(Double weight) {
        this.weight = weight;
        return this;
    }

    public UpdateUserRequestDto build() {
        return new UpdateUserRequestDto(height, weight);
    }
}
