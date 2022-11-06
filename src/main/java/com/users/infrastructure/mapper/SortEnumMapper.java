package com.users.infrastructure.mapper;

import com.users.domain.model.SortEnum;
import com.users.infrastructure.dto.SortEnumDto;

public class SortEnumMapper {

    private SortEnumMapper() {
        super();
    }

    public static SortEnum toSortEnum(SortEnumDto dto) {
        return SortEnum.integerToSortEnum(dto.getValue());
    }
}
