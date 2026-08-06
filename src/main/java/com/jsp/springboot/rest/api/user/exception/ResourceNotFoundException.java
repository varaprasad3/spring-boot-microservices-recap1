package com.jsp.springboot.rest.api.user.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


public class ResourceNotFoundException extends RuntimeException {

    private String fieldType ;
    private String fieldName ;
    private Integer fieldValue ;

    public ResourceNotFoundException(String fieldType, String fieldName, Integer fieldValue) {
        super(String.format("%s not found with %s : '%s'", fieldType, fieldName, fieldValue));
        this.fieldName = fieldName;
        this.fieldType = fieldType;
        this.fieldValue = fieldValue;
    }

}
