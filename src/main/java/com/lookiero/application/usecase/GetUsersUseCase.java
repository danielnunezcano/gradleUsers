package com.lookiero.application.usecase;

import com.lookiero.application.usecase.annotation.UseCase;
import com.lookiero.aspects.Logger;
import com.lookiero.domain.model.SortEnum;
import com.lookiero.domain.model.User;
import com.lookiero.infrastructure.service.UserService;

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
