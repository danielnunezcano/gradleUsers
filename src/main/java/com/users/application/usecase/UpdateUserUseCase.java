package com.users.application.usecase;

import com.users.application.usecase.annotation.UseCase;
import com.users.aspects.Logger;
import com.users.domain.constants.Constants;
import com.users.domain.model.User;
import com.users.infrastructure.service.UserService;

@UseCase
public class UpdateUserUseCase {

    private final Constants getConstants;

    private final UserService userService;

    public UpdateUserUseCase(Constants getConstants, UserService userService) {
        this.getConstants = getConstants;
        this.userService = userService;
    }

    @Logger
    public User execute(final User updateUser) {
        validations(updateUser);
        User user = userService.findUserById(updateUser.getId());
        user.updateHeightWeightUser(updateUser);
        return userService.updateUser(user);
    }

    private void validations(final User user) {
        Validation.validationHeight(user.getHeight(), getConstants.getHeightLess(), getConstants.getHeightOver());
        Validation.validationWeight(user.getWeight(), getConstants.getWeightLess(), getConstants.getWeightOver());
    }
}
