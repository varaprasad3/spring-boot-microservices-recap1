package com.jsp.springboot.rest.api.user.dto;

import com.jsp.springboot.rest.api.user.entity.User;

public class UserMapper {

    public static UserDto mapUserToUserDto(User user) {
        UserDto userDto = new UserDto(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail()
        );
        return userDto;
    }

    public static User mapUserDtoToUser(UserDto userDto) {
        User user = new User(userDto.getId(),
                userDto.getFirstName(),
                userDto.getLastName(),
                userDto.getEmail());

        return user;
    }
}
