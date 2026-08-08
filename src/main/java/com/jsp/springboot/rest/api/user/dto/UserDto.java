package com.jsp.springboot.rest.api.user.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Schema(
        description = "User DTO Model information"
)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    @Schema(
            description = "User Id"
    )
    private Integer id  ;

    @NotEmpty(message = "firstName must not be empty or null")
    @Schema(
            description = "User First Name"
    )
    private String firstName ;

    @NotEmpty(message = "lastName must not be empty or null")
    @Schema(
            description = "User Last Name"
    )
    private String lastName ;

    @NotEmpty(message = "email must not be empty or null")
    @Schema(
            description = "User Email Address"
    )
    @Email(message = "email must be a valid email address")
    private String email ;

}
