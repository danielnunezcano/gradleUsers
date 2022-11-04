package com.lookiero.infrastructure.controller;

import com.lookiero.application.usecase.AddUserUseCase;
import com.lookiero.application.usecase.GetUsersUseCase;
import com.lookiero.application.usecase.UpdateUserUseCase;
import com.lookiero.domain.model.SortEnum;
import com.lookiero.domain.model.User;
import com.lookiero.domain.model.builder.UserBuilder;
import com.lookiero.domain.utils.DateUtils;
import com.lookiero.infrastructure.dto.SortEnumDto;
import com.lookiero.infrastructure.dto.UpdateUserRequestDto;
import com.lookiero.infrastructure.dto.UserRequestDto;
import com.lookiero.infrastructure.dto.UserResponseDto;
import com.lookiero.infrastructure.dto.builder.UpdateUserRequestDtoBuilder;
import com.lookiero.infrastructure.dto.builder.UserRequestDtoBuilder;
import com.lookiero.infrastructure.dto.builder.UserResponseDtoBuilder;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserControllerTest {
    @InjectMocks
    private UserController userController;

    @Mock
    private AddUserUseCase addUserUseCase;

    @Mock
    private UpdateUserUseCase updateUserUseCase;

    @Mock
    private GetUsersUseCase getUsersUseCase;

    @Nested
    class execute {

        private static final String NAME = "Name1234";
        private static final String PASSWORD = "a1b2c3c4";
        private static final String BIRTHDATE = "01/01/2000";
        private static final Double HEIGHT = 1.5;
        private static final Double WEIGHT = 75.2;
        private static final Integer ID = 1;
        private static final Double BMI = WEIGHT / (HEIGHT * HEIGHT);

        private static final UserResponseDto userResponseDto = new UserResponseDtoBuilder().id(ID)
                .name(NAME).password(PASSWORD).birthdate(DateUtils.stringToDate(BIRTHDATE))
                .height(HEIGHT).weight(WEIGHT).bmi(BMI).build();
        private static final User user = new UserBuilder().id(ID)
                .name(NAME).password(PASSWORD).birthdate(DateUtils.stringToDate(BIRTHDATE))
                .height(HEIGHT).weight(WEIGHT).bmi(BMI).build();


        @Nested
        class addUser {
            private final UserRequestDto userRequestDto = new UserRequestDtoBuilder()
                    .name(NAME).password(PASSWORD).birthdate(DateUtils.stringToDate(BIRTHDATE))
                    .height(HEIGHT).weight(WEIGHT).build();

            @Test
            void shouldCallUseCaseOk() {
                when(addUserUseCase.execute(any(User.class))).thenReturn(user);
                ResponseEntity<UserResponseDto> response = userController.addUser(userRequestDto);
                verify(addUserUseCase, times(1)).execute(any(User.class));
                assertThat(HttpStatus.CREATED).isEqualTo(response.getStatusCode());
                assertThat(userResponseDto).isEqualTo(response.getBody());
            }
        }

        @Nested
        class updateUser {
            private final UpdateUserRequestDto updateUserRequestDto = new UpdateUserRequestDtoBuilder()
                    .height(HEIGHT).weight(WEIGHT).build();

            @Test
            void shouldCallUseCaseOk() {
                when(updateUserUseCase.execute(any(User.class))).thenReturn(user);
                ResponseEntity<UserResponseDto> response = userController.updateUser(ID, updateUserRequestDto);
                verify(updateUserUseCase, times(1)).execute(any(User.class));
                assertThat(HttpStatus.OK).isEqualTo(response.getStatusCode());
                assertThat(userResponseDto).isEqualTo(response.getBody());
            }
        }

        @Nested
        class getUsers {
            @Test
            void shouldCallUseCaseOk() {
                when(getUsersUseCase.execute(any(SortEnum.class))).thenReturn(List.of(user));
                ResponseEntity<List<UserResponseDto>> response = userController.getUsers(null);
                verify(getUsersUseCase, times(1)).execute(SortEnum.BIRTHDAY);
                assertThat(HttpStatus.OK).isEqualTo(response.getStatusCode());
                assertThat(List.of(userResponseDto)).isEqualTo(response.getBody());
            }

            @Test
            void shouldCallUseCaseBmiOk() {
                when(getUsersUseCase.execute(any(SortEnum.class))).thenReturn(List.of(user));
                ResponseEntity<List<UserResponseDto>> response = userController.getUsers(SortEnumDto.BMI);
                verify(getUsersUseCase, times(1)).execute(SortEnum.BMI);
                assertThat(HttpStatus.OK).isEqualTo(response.getStatusCode());
                assertThat(List.of(userResponseDto)).isEqualTo(response.getBody());
            }
        }
    }
}