package com.lookiero.infrastructure.exception;

import com.lookiero.domain.exception.*;
import com.lookiero.infrastructure.dto.ErrorDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Order(Ordered.HIGHEST_PRECEDENCE)
@RestControllerAdvice
public class RestApiExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(RestApiExceptionHandler.class);

    private static final String MESSAGE = "Error: ";

    @ExceptionHandler(UserExistException.class)
    public ResponseEntity<ErrorDto> handleUserExistException(final UserExistException exception) {
        return badRequestException(exception);
    }

    @ExceptionHandler(AgeLess18Exception.class)
    public ResponseEntity<ErrorDto> handleAgeLess18Exception(final AgeLess18Exception exception) {
        return badRequestException(exception);
    }

    @ExceptionHandler(HeightException.class)
    public ResponseEntity<ErrorDto> handleHeightException(final HeightException exception) {
        return badRequestException(exception);
    }

    @ExceptionHandler(NameFormatException.class)
    public ResponseEntity<ErrorDto> handleNameFormatException(final NameFormatException exception) {
        return badRequestException(exception);
    }

    @ExceptionHandler(PasswordNullException.class)
    public ResponseEntity<ErrorDto> handlePasswordNullException(final PasswordNullException exception) {
        return badRequestException(exception);
    }

    @ExceptionHandler(UserNullException.class)
    public ResponseEntity<ErrorDto> handleUserNullException(final UserNullException exception) {
        return badRequestException(exception);
    }

    @ExceptionHandler(WeightException.class)
    public ResponseEntity<ErrorDto> handleWeightException(final WeightException exception) {
        return badRequestException(exception);
    }

    @ExceptionHandler(SortOptionException.class)
    public ResponseEntity<ErrorDto> handleSortOptionException(final SortOptionException exception) {
        return badRequestException(exception);
    }

    @ExceptionHandler(Exception.class)
    protected ResponseEntity<ErrorDto> handlerException(final Exception exception) {
        LOGGER.error(MESSAGE, exception);
        return buildResponse(HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage());
    }

    private ResponseEntity<ErrorDto> badRequestException(final RuntimeException exception) {
        LOGGER.error(MESSAGE, exception);
        return buildResponse(HttpStatus.BAD_REQUEST, exception.getMessage());
    }

    private ResponseEntity<ErrorDto> buildResponse(final HttpStatus status, final String message) {
        final ErrorDto errorDTO = new ErrorDto(status.value(), status.name(), message);
        return new ResponseEntity<>(errorDTO, status);
    }

}
