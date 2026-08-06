package com.jsp.springboot.rest.api.user.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private Integer id  ;

    @NotEmpty(message = "firstName must not be empty or null")
    private String firstName ;

    @NotEmpty(message = "lastName must not be empty or null")
    private String lastName ;

    @NotEmpty(message = "email must not be empty or null")
    @Email(message = "email must be a valid email address")
    private String email ;

}
