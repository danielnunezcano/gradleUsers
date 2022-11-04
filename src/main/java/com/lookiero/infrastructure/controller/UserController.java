package com.lookiero.infrastructure.controller;

import com.lookiero.application.usecase.AddUserUseCase;
import com.lookiero.application.usecase.GetUsersUseCase;
import com.lookiero.application.usecase.UpdateUserUseCase;
import com.lookiero.aspects.Logger;
import com.lookiero.domain.model.SortEnum;
import com.lookiero.domain.model.User;
import com.lookiero.infrastructure.dto.SortEnumDto;
import com.lookiero.infrastructure.dto.UpdateUserRequestDto;
import com.lookiero.infrastructure.dto.UserRequestDto;
import com.lookiero.infrastructure.dto.UserResponseDto;
import com.lookiero.infrastructure.mapper.SortEnumMapper;
import com.lookiero.infrastructure.mapper.UserMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private final AddUserUseCase addUserUseCase;

    private final UpdateUserUseCase updateUserUseCase;

    private final GetUsersUseCase getUsersUseCase;

    public UserController(AddUserUseCase addUserUseCase, UpdateUserUseCase updateUserUseCase, GetUsersUseCase getUsersUseCase) {
        this.addUserUseCase = addUserUseCase;
        this.updateUserUseCase = updateUserUseCase;
        this.getUsersUseCase = getUsersUseCase;
    }

    @Logger
    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public ResponseEntity<UserResponseDto> addUser(@RequestBody UserRequestDto user) {
        return new ResponseEntity<>(UserMapper.toDto(addUserUseCase.execute(UserMapper.toModel(user))),
                HttpStatus.CREATED);
    }

    @Logger
    @RequestMapping(value = "/users/{id}", method = RequestMethod.PUT)
    public ResponseEntity<UserResponseDto> updateUser(
            @PathVariable Integer id, @RequestBody UpdateUserRequestDto user) {
        return ResponseEntity.ok(UserMapper.toDto(updateUserUseCase.execute(UserMapper.toModel(id, user))));
    }

    @Logger
    @RequestMapping(value = {"/users", "/users/{sort}"}, method = RequestMethod.GET)
    public ResponseEntity<List<UserResponseDto>> getUsers(@PathVariable(required = false) SortEnumDto sort) {
        if (sort == null) sort = SortEnumDto.BIRTHDAY;
        return ResponseEntity.ok(UserMapper.toDto(getUsersUseCase.execute(SortEnumMapper.toSortEnum(sort))));
    }

}
