package com.lookiero.application.usecase;

import com.lookiero.domain.constants.Constants;
import com.lookiero.domain.exception.HeightException;
import com.lookiero.domain.exception.WeightException;
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

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import static com.fasterxml.jackson.databind.type.LogicalType.DateTime;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
class UpdateUserUseCaseTest {

    @InjectMocks
    private UpdateUserUseCase useCase;

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

        @Test
        void shouldCallUpdateUserService() {
            when(constants.getHeightLess()).thenReturn(2.3);
            when(constants.getHeightOver()).thenReturn(1.0);
            when(constants.getWeightLess()).thenReturn(150.0);
            when(constants.getWeightOver()).thenReturn(40.0);
            User userRequest = new UserBuilder().id(ID).height(HEIGHT).weight(WEIGHT).build();
            User userResponse = new UserBuilder().id(ID).name(NAME)
                    .birthdate(DateUtils.stringToDate(BIRTHDATE)).height(HEIGHT).weight(WEIGHT).build();
            User user = new UserBuilder().id(ID).name(NAME)
                    .birthdate(DateUtils.stringToDate(BIRTHDATE)).height(HEIGHT + 0.1).weight(WEIGHT + 0.1).build();
            when(userService.findUserById(ID)).thenReturn(user);
            when(userService.updateUser(userResponse)).thenReturn(userResponse);
            User response = useCase.execute(userRequest);
            verify(userService, times(1)).findUserById(ID);
            verify(userService, times(1)).updateUser(userResponse);
            assertThat(userResponse).isEqualTo(response);
        }

        @Test
        void shouldThrowExceptionBecauseHeightIsLess() {
            when(constants.getHeightLess()).thenReturn(2.3);
            when(constants.getHeightOver()).thenReturn(1.0);
            final Double height = 0.9;
            User userRequest = new UserBuilder().name(NAME).password(PASSWORD)
                    .birthdate(DateUtils.stringToDate(BIRTHDATE)).height(height).weight(WEIGHT).build();
            assertThrows(HeightException.class, () -> useCase.execute(userRequest));
        }

        @Test
        void shouldThrowExceptionBecauseHeightIsOver() {
            when(constants.getHeightLess()).thenReturn(2.3);
            when(constants.getHeightOver()).thenReturn(1.0);
            final Double height = 2.4;
            User userRequest = new UserBuilder().name(NAME).password(PASSWORD)
                    .birthdate(DateUtils.stringToDate(BIRTHDATE)).height(height).weight(WEIGHT).build();
            assertThrows(HeightException.class, () -> useCase.execute(userRequest));
        }

        @Test
        void shouldThrowExceptionBecauseWeightIsLess() {
            when(constants.getHeightLess()).thenReturn(2.3);
            when(constants.getHeightOver()).thenReturn(1.0);
            when(constants.getWeightLess()).thenReturn(150.0);
            when(constants.getWeightOver()).thenReturn(40.0);
            final Double weight = 39.0;
            User userRequest = new UserBuilder().name(NAME).password(PASSWORD)
                    .birthdate(DateUtils.stringToDate(BIRTHDATE)).height(HEIGHT).weight(weight).build();
            assertThrows(WeightException.class, () -> useCase.execute(userRequest));
        }

        @Test
        void shouldThrowExceptionBecauseWeightIsOver() {
            when(constants.getHeightLess()).thenReturn(2.3);
            when(constants.getHeightOver()).thenReturn(1.0);
            when(constants.getWeightLess()).thenReturn(150.0);
            when(constants.getWeightOver()).thenReturn(40.0);
            final Double weight = 151.0;
            User userRequest = new UserBuilder().name(NAME).password(PASSWORD)
                    .birthdate(DateUtils.stringToDate(BIRTHDATE)).height(HEIGHT).weight(weight).build();
            assertThrows(WeightException.class, () -> useCase.execute(userRequest));
        }

    }
}
