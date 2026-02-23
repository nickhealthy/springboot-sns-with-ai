package com.nickhealthy.springboot_sns_sample.exception;

import com.nickhealthy.springboot_sns_sample.domain.user.UserException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserException.class)
    public ResponseEntity<ErrorResponse> handleUserException(UserException e) {
        HttpStatus status = switch (e.getErrorCode()) {
            case USER_NOT_FOUND -> HttpStatus.NOT_FOUND;
            case DUPLICATE_USERNAME -> HttpStatus.CONFLICT;
        };
        return ResponseEntity.status(status)
                .body(new ErrorResponse(e.getErrorCode().name(), e.getMessage(), LocalDateTime.now()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidationException(MethodArgumentNotValidException e) {
        String message = e.getBindingResult().getFieldErrors().stream()
                .map(fe -> fe.getField() + ": " + fe.getDefaultMessage())
                .collect(Collectors.joining(", "));
        return ResponseEntity.badRequest()
                .body(new ErrorResponse("VALIDATION_FAILED", message, LocalDateTime.now()));
    }

    public record ErrorResponse(String code, String message, LocalDateTime timestamp) {
    }
}
