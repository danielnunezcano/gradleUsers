package com.lookiero.application.usecase;

import com.lookiero.application.usecase.annotation.UseCase;
import com.lookiero.aspects.Logger;
import com.lookiero.domain.constants.Constants;
import com.lookiero.domain.exception.*;
import com.lookiero.domain.model.User;
import com.lookiero.infrastructure.service.UserService;

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
