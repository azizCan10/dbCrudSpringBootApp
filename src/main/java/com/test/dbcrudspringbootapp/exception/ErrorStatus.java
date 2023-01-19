package com.test.dbcrudspringbootapp.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorStatus {
    USER_NOT_FOUND("User not found", HttpStatus.NOT_FOUND);

    private String message;
    private HttpStatus httpStatus;
}
