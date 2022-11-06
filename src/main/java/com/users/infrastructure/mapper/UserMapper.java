package com.users.infrastructure.mapper;

import com.users.domain.model.User;
import com.users.domain.model.builder.UserBuilder;
import com.users.infrastructure.dto.UpdateUserRequestDto;
import com.users.infrastructure.dto.UserRequestDto;
import com.users.infrastructure.dto.UserResponseDto;
import com.users.infrastructure.dto.builder.UserResponseDtoBuilder;
import com.users.infrastructure.repository.jpa.UserJpa;
import com.users.infrastructure.repository.jpa.builder.UserJpaBuilder;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class UserMapper {

    private UserMapper() {
        super();
    }

    public static UserJpa toJpa(final User user) {
        return new UserJpaBuilder()
                .id(user.getId())
                .name(user.getName())
                .password(user.getPassword())
                .birthdate(user.getBirthdate())
                .height(user.getHeight())
                .weight(user.getWeight())
                .bmi(user.getBmi())
                .createdDate(new Date())
                .createdUser(user.getName())
                .build();
    }

    public static User toModel(final UserJpa userJpa) {
        return new UserBuilder()
                .id(userJpa.getId())
                .name(userJpa.getName())
                .password(userJpa.getPassword())
                .birthdate(userJpa.getBirthdate())
                .height(userJpa.getHeight())
                .weight(userJpa.getWeight())
                .bmi(userJpa.getBmi())
                .build();
    }

    public static List<User> toModel(final List<UserJpa> userJpaList) {
        if (userJpaList.isEmpty()) {
            return new ArrayList<>();
        }
        return userJpaList.stream().map(user -> toModel(user)).collect(Collectors.toList());
    }

    public static UserResponseDto toDto(User user) {
        return new UserResponseDtoBuilder()
                .id(user.getId())
                .name(user.getName())
                .birthdate(user.getBirthdate())
                .height(user.getHeight())
                .weight(user.getWeight())
                .bmi(user.getBmi())
                .build();
    }

    public static List<UserResponseDto> toDto(final List<User> userList) {
        if (userList.isEmpty()) {
            return new ArrayList<>();
        }
        return userList.stream().map(user -> toDto(user)).collect(Collectors.toList());
    }

    public static User toModel(UserRequestDto userRequestDto) {
        User output = new UserBuilder()
                .name(userRequestDto.getName())
                .password(userRequestDto.getPassword())
                .birthdate(userRequestDto.getBirthdate())
                .height(userRequestDto.getHeight())
                .weight(userRequestDto.getWeight())
                .build();
        output.updateBmi();
        return output;
    }

    public static User toModel(Integer id, UpdateUserRequestDto updateUserRequestDto) {
        return new UserBuilder()
                .id(id)
                .height(updateUserRequestDto.getHeight())
                .weight(updateUserRequestDto.getWeight())
                .build();
    }

}
