package com.lookiero.application.usecase;

import com.lookiero.domain.constants.Constants;
import com.lookiero.domain.exception.*;
import com.lookiero.domain.model.User;
import com.lookiero.domain.model.builder.UserBuilder;
import com.lookiero.domain.utils.DateUtils;
import com.lookiero.infrastructure.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AddUserUseCaseTest {

    @InjectMocks
    private AddUserUseCase useCase;

    @Mock
    private UserService userService;

    @Mock
    private Constants constants;

    @Nested
    class execute {

        private static final String NAME = "Name1234";
        private static final String PASSWORD = "a1b2c3c4";
        private static final String BIRTHDATE = "01/01/2000";
        private static final Double HEIGHT = 1.5;
        private static final Double WEIGHT = 75.2;
        private static final Integer ID = 1;
        private static final Double BMI = WEIGHT / (HEIGHT * HEIGHT);

        @Test
        void shouldCallAddUserService() {
            when(constants.getHeightLess()).thenReturn(2.3);
            when(constants.getHeightOver()).thenReturn(1.0);
            when(constants.getWeightLess()).thenReturn(150.0);
            when(constants.getWeightOver()).thenReturn(40.0);
            when(constants.getNameRegex()).thenReturn("^[\\^s\\S]{8,25}$");
            User userRequest = new UserBuilder().name(NAME).password(PASSWORD)
                    .birthdate(DateUtils.stringToDate(BIRTHDATE)).height(HEIGHT).weight(WEIGHT).build();
            User userResponse = new UserBuilder().id(ID).name(NAME)
                    .birthdate(DateUtils.stringToDate(BIRTHDATE)).height(HEIGHT).weight(WEIGHT).bmi(BMI).build();
            when(userService.existUserByName(anyString())).thenReturn(Boolean.FALSE);
            when(userService.addUser(userRequest)).thenReturn(userResponse);
            User response = useCase.execute(userRequest);
            verify(userService, times(1)).existUserByName(anyString());
            verify(userService, times(1)).addUser(userRequest);
            assertThat(userResponse).isEqualTo(response);
        }

        @Test
        void shouldThrowExceptionBecauseUserExist() {
            when(constants.getNameRegex()).thenReturn("^[\\^s\\S]{8,25}$");
            User userRequest = new UserBuilder().name(NAME).password(PASSWORD)
                    .birthdate(DateUtils.stringToDate(BIRTHDATE)).height(HEIGHT).weight(WEIGHT).build();
            when(userService.existUserByName(anyString())).thenReturn(Boolean.TRUE);
            assertThrows(UserExistException.class, () -> useCase.execute(userRequest));
            verify(userService, times(1)).existUserByName(anyString());
        }

        @Test
        void shouldThrowExceptionBecauseUserNameIsNull() {
            User userRequest = new UserBuilder().name(null).password(PASSWORD)
                    .birthdate(DateUtils.stringToDate(BIRTHDATE)).height(HEIGHT).weight(WEIGHT).build();
            assertThrows(UserNullException.class, () -> useCase.execute(userRequest));
        }

        @Test
        void shouldThrowExceptionBecauseNameIsIncorrectFormat() {
            when(constants.getNameRegex()).thenReturn("^[\\^s\\S]{8,25}$");
            final String name = "13 dsafer";
            User userRequest = new UserBuilder().name(name).password(PASSWORD)
                    .birthdate(DateUtils.stringToDate(BIRTHDATE)).height(HEIGHT).weight(WEIGHT).build();
            assertThrows(NameFormatException.class, () -> useCase.execute(userRequest));
        }

        @Test
        void shouldThrowExceptionBecausePasswordIsNull() {
            when(constants.getNameRegex()).thenReturn("^[\\^s\\S]{8,25}$");
            User userRequest = new UserBuilder().name(NAME).password(null)
                    .birthdate(DateUtils.stringToDate(BIRTHDATE)).height(HEIGHT).weight(WEIGHT).build();
            when(userService.existUserByName(anyString())).thenReturn(Boolean.FALSE);
            assertThrows(PasswordNullException.class, () -> useCase.execute(userRequest));
            verify(userService, times(1)).existUserByName(anyString());
        }

        @Test
        void shouldThrowExceptionBecauseAgeIsLess18() {
            when(constants.getNameRegex()).thenReturn("^[\\^s\\S]{8,25}$");
            final String birthdayMinus18 = "01/01/2010";
            User userRequest = new UserBuilder().name(NAME).password(PASSWORD)
                    .birthdate(DateUtils.stringToDate(birthdayMinus18)).height(HEIGHT).weight(WEIGHT).build();
            when(userService.existUserByName(anyString())).thenReturn(Boolean.FALSE);
            assertThrows(AgeLess18Exception.class, () -> useCase.execute(userRequest));
            verify(userService, times(1)).existUserByName(anyString());
        }

        @Test
        void shouldThrowExceptionBecauseHeightIsLess() {
            when(constants.getHeightLess()).thenReturn(2.3);
            when(constants.getHeightOver()).thenReturn(1.0);
            when(constants.getNameRegex()).thenReturn("^[\\^s\\S]{8,25}$");
            final Double height = 0.9;
            User userRequest = new UserBuilder().name(NAME).password(PASSWORD)
                    .birthdate(DateUtils.stringToDate(BIRTHDATE)).height(height).weight(WEIGHT).build();
            when(userService.existUserByName(anyString())).thenReturn(Boolean.FALSE);
            assertThrows(HeightException.class, () -> useCase.execute(userRequest));
            verify(userService, times(1)).existUserByName(anyString());
        }

        @Test
        void shouldThrowExceptionBecauseHeightIsOver() {
            when(constants.getHeightLess()).thenReturn(2.3);
            when(constants.getHeightOver()).thenReturn(1.0);
            when(constants.getNameRegex()).thenReturn("^[\\^s\\S]{8,25}$");
            final Double height = 2.4;
            User userRequest = new UserBuilder().name(NAME).password(PASSWORD)
                    .birthdate(DateUtils.stringToDate(BIRTHDATE)).height(height).weight(WEIGHT).build();
            when(userService.existUserByName(anyString())).thenReturn(Boolean.FALSE);
            assertThrows(HeightException.class, () -> useCase.execute(userRequest));
            verify(userService, times(1)).existUserByName(anyString());
        }

        @Test
        void shouldThrowExceptionBecauseWeightIsLess() {
            when(constants.getHeightLess()).thenReturn(2.3);
            when(constants.getHeightOver()).thenReturn(1.0);
            when(constants.getWeightLess()).thenReturn(150.0);
            when(constants.getWeightOver()).thenReturn(40.0);
            when(constants.getNameRegex()).thenReturn("^[\\^s\\S]{8,25}$");
            final Double weight = 39.0;
            User userRequest = new UserBuilder().name(NAME).password(PASSWORD)
                    .birthdate(DateUtils.stringToDate(BIRTHDATE)).height(HEIGHT).weight(weight).build();
            when(userService.existUserByName(anyString())).thenReturn(Boolean.FALSE);
            assertThrows(WeightException.class, () -> useCase.execute(userRequest));
            verify(userService, times(1)).existUserByName(anyString());
        }

        @Test
        void shouldThrowExceptionBecauseWeightIsOver() {
            when(constants.getHeightLess()).thenReturn(2.3);
            when(constants.getHeightOver()).thenReturn(1.0);
            when(constants.getWeightLess()).thenReturn(150.0);
            when(constants.getWeightOver()).thenReturn(40.0);
            when(constants.getNameRegex()).thenReturn("^[\\^s\\S]{8,25}$");
            final Double weight = 151.0;
            User userRequest = new UserBuilder().name(NAME).password(PASSWORD)
                    .birthdate(DateUtils.stringToDate(BIRTHDATE)).height(HEIGHT).weight(weight).build();
            when(userService.existUserByName(anyString())).thenReturn(Boolean.FALSE);
            assertThrows(WeightException.class, () -> useCase.execute(userRequest));
            verify(userService, times(1)).existUserByName(anyString());
        }

    }
}