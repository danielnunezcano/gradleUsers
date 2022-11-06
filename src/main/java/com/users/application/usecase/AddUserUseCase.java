package com.users.application.usecase;

import com.users.application.usecase.annotation.UseCase;
import com.users.aspects.Logger;
import com.users.domain.constants.Constants;
import com.users.domain.exception.*;
import com.users.domain.model.User;
import com.users.infrastructure.service.UserService;

@UseCase
public class AddUserUseCase {

    private final Constants getConstants;

    private final UserService userService;

    public AddUserUseCase(Constants getConstants, UserService userService) {
        this.getConstants = getConstants;
        this.userService = userService;
    }

    @Logger
    public User execute(final User user) {
        validations(user);
        return userService.addUser(user);
    }

    private void validations(final User user) {
        Validation.validationBlankName(user.getName());
        Validation.validationNameFormat(user.getName(), getConstants.getNameRegex());
        validationExistUser(user.getName());
        Validation.validationPassword(user.getPassword());
        Validation.validationAge(user.getBirthdate());
        Validation.validationHeight(user.getHeight(), getConstants.getHeightLess(), getConstants.getHeightOver());
        Validation.validationWeight(user.getWeight(), getConstants.getWeightLess(), getConstants.getWeightOver());
    }

    private void validationExistUser(final String name) {
        if (userService.existUserByName(name)) {
            throw new UserExistException(name);
        }
    }
}
