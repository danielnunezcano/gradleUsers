package com.users.application.usecase;

import com.users.application.usecase.annotation.UseCase;
import com.users.aspects.Logger;
import com.users.domain.model.SortEnum;
import com.users.domain.model.User;
import com.users.infrastructure.service.UserService;

import java.util.List;

@UseCase
public class GetUsersUseCase {

    private final UserService userService;

    public GetUsersUseCase(UserService userService) {
        this.userService = userService;
    }

    @Logger
    public List<User> execute(final SortEnum sortEnum) {
        if (SortEnum.BMI.equals(sortEnum)) {
            return userService.getUserOrderByBmi();
        } else {
            return userService.getUserOrderByBirthday();
        }
    }

}
