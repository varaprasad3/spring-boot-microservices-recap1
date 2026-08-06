package com.jsp.springboot.rest.api.user.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorDetails {
    LocalDateTime timestamp ;
    String message ;
    String path ;
    String errorCode ;
}
