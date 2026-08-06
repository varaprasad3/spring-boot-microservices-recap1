package com.jsp.springboot.rest.api.user.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EmailAlreadyExistsException extends RuntimeException {
    public String message ;
    public EmailAlreadyExistsException(String message) {
        super(message) ;
    }
}
