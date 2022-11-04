package com.lookiero.application.usecase;

import com.lookiero.domain.exception.HeightException;
import com.lookiero.domain.exception.WeightException;
import com.lookiero.domain.model.SortEnum;
import com.lookiero.domain.model.User;
import com.lookiero.domain.model.builder.UserBuilder;
import com.lookiero.domain.utils.DateUtils;
import com.lookiero.infrastructure.dto.SortEnumDto;
import com.lookiero.infrastructure.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class GetUsersUseCaseTest {

    @InjectMocks
    private GetUsersUseCase useCase;

    @Mock
    private UserService userService;

    @Nested
    class execute {

        @Test
        void shouldCallBirthdayService() {
            when(userService.getUserOrderByBirthday()).thenReturn(new ArrayList<>());
            useCase.execute(SortEnum.BIRTHDAY);
            verify(userService, times(1)).getUserOrderByBirthday();
        }

        @Test
        void shouldCallBmiService() {
            when(userService.getUserOrderByBmi()).thenReturn(new ArrayList<>());
            useCase.execute(SortEnum.BMI);
            verify(userService, times(1)).getUserOrderByBmi();
        }

    }
}
