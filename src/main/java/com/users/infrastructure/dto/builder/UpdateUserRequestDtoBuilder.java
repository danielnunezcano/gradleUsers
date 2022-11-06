package com.users.infrastructure.dto.builder;

import com.users.infrastructure.dto.UpdateUserRequestDto;

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
