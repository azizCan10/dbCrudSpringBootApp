package com.test.dbcrudspringbootapp.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class CustomException extends RuntimeException {
    private String message;
    private HttpStatus httpStatus;

    public CustomException(ErrorStatus errorStatus) {
        this.message = errorStatus.getMessage();
        this.httpStatus = errorStatus.getHttpStatus();
    }
}
