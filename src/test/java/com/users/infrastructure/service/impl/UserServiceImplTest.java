package com.users.infrastructure.service.impl;

import com.users.domain.exception.UserNotExistException;
import com.users.domain.model.User;
import com.users.domain.model.builder.UserBuilder;
import com.users.infrastructure.repository.UserJpaRepository;
import com.users.infrastructure.repository.jpa.UserJpa;
import com.users.infrastructure.repository.jpa.builder.UserJpaBuilder;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @InjectMocks
    private UserServiceImpl userService;

    @Mock
    private UserJpaRepository userJpaRepository;

    private static final String NAME = "Name";
    private static final LocalDate BIRTHDATE = LocalDate.now();
    private static final Double HEIGHT = 1.5;
    private static final Double WEIGHT = 75.2;
    private static final Integer ID = 1;
    private static final Double BMI = WEIGHT / (HEIGHT * HEIGHT);
    private static final User userRequest = new UserBuilder().name(NAME).birthdate(BIRTHDATE).height(HEIGHT).weight(WEIGHT).build();
    private static final User userResponse =
            new UserBuilder().id(ID).name(NAME).birthdate(BIRTHDATE).height(HEIGHT).weight(WEIGHT).bmi(BMI).build();
    private static final UserJpa userJpa = new UserJpaBuilder().id(ID).name(NAME).birthdate(BIRTHDATE).height(HEIGHT).weight(WEIGHT)
            .bmi(BMI).createdDate(new Date()).createdUser(NAME).build();

    @Nested
    class addUser {
        @Test
        void shouldAddUser() {
            when(userJpaRepository.save(any(UserJpa.class))).thenReturn(userJpa);
            any(String.class);
            User response = userService.addUser(userRequest);
            verify(userJpaRepository, times(1)).save(any(UserJpa.class));
            assertThat(userResponse).isEqualTo(response);
        }

    }

    @Nested
    class updateUser {

        @Test
        void shouldUpdateUser() {
            User user = new UserBuilder().id(ID).height(HEIGHT).weight(WEIGHT).build();
            when(userJpaRepository.save(any(UserJpa.class))).thenReturn(userJpa);
            User response = userService.updateUser(user);
            verify(userJpaRepository, times(1)).save(any(UserJpa.class));
            assertThat(userResponse).isEqualTo(response);
        }

    }

    @Nested
    class getUserOrderByBirthday {

        @Test
        void shouldUpdateUser() {
            List<User> userList = List.of(userResponse);
            List<UserJpa> userJpaList = List.of(userJpa);
            when(userJpaRepository.findAllByOrderByBirthdate()).thenReturn(userJpaList);
            List<User> response = userService.getUserOrderByBirthday();
            verify(userJpaRepository, times(1)).findAllByOrderByBirthdate();
            assertThat(userList).isEqualTo(response);
        }

    }

    @Nested
    class getUserOrderByBmi {

        @Test
        void shouldUpdateUser() {
            List<User> userList = List.of(userResponse);
            List<UserJpa> userJpaList = List.of(userJpa);
            when(userJpaRepository.findAllByOrderByBmi()).thenReturn(userJpaList);
            List<User> response = userService.getUserOrderByBmi();
            verify(userJpaRepository, times(1)).findAllByOrderByBmi();
            assertThat(userList).isEqualTo(response);
        }

    }

    @Nested
    class findUserById {
        @Test
        void shouldReturnUser() {
            when(userJpaRepository.findById(ID)).thenReturn(Optional.of(userJpa));
            User response = userService.findUserById(ID);
            verify(userJpaRepository, times(1)).findById(ID);
            assertThat(userResponse).isEqualTo(response);
        }

        @Test
        void shouldReturnExceptionBecauseUserNotExist() {
            when(userJpaRepository.findById(ID)).thenReturn(Optional.empty());
            assertThrows(UserNotExistException.class, () -> userService.findUserById(ID));
            verify(userJpaRepository, times(1)).findById(ID);
        }
    }

    @Nested
    class existUserByName {
        @Test
        void shouldReturnTrueIfUserExist() {
            when(userJpaRepository.existsByName(anyString())).thenReturn(Boolean.TRUE);
            Boolean response = userService.existUserByName(NAME);
            verify(userJpaRepository, times(1)).existsByName(any(String.class));
            assertThat(Boolean.TRUE).isEqualTo(response);
        }

    }

}