package com.lookiero.infrastructure.mapper;

import com.lookiero.domain.model.SortEnum;
import com.lookiero.domain.model.User;
import com.lookiero.domain.model.builder.UserBuilder;
import com.lookiero.infrastructure.dto.SortEnumDto;
import com.lookiero.infrastructure.dto.UpdateUserRequestDto;
import com.lookiero.infrastructure.dto.UserRequestDto;
import com.lookiero.infrastructure.dto.UserResponseDto;
import com.lookiero.infrastructure.dto.builder.UserResponseDtoBuilder;
import com.lookiero.infrastructure.repository.jpa.UserJpa;
import com.lookiero.infrastructure.repository.jpa.builder.UserJpaBuilder;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class SortEnumMapper {

    private SortEnumMapper() {
        super();
    }

    public static SortEnum toSortEnum(SortEnumDto dto) {
        return SortEnum.integerToSortEnum(dto.getValue());
    }
}
