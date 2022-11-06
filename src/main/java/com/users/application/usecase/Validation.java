package com.users.application.usecase;

import com.users.domain.exception.*;
import com.users.domain.utils.DateUtils;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class Validation {

    protected static void validationPassword(final String password) {
        if (Strings.isBlank(password)) {
            throw new PasswordNullException();
        }
    }

    protected static void validationAge(final LocalDate birthday) {
        if (DateUtils.ageLess18(birthday)) {
            throw new AgeLess18Exception();
        }
    }

    protected static void validationHeight(
            final Double height, final Double heightLess, final Double heightOver) {
        if (heightOver > height || heightLess < height) {
            throw new HeightException(height);
        }
    }

    protected static void validationWeight(
            final Double weight, final Double weightLess, final Double weightOver) {
        if (weightOver > weight || weightLess < weight) {
            throw new WeightException(weight);
        }
    }

    protected static void validationBlankName(final String name) {
        if (Strings.isBlank(name)) {
            throw new UserNullException();
        }
    }

    protected static void validationNameFormat(final String name, final String nameRegex) {
        Pattern pattern = Pattern.compile(nameRegex);
        Matcher matcher = pattern.matcher(name);
        if (!matcher.find()) {
            throw new NameFormatException();
        }
    }


}
