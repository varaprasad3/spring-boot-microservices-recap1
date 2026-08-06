package com.jsp.springboot.rest.api.user.mapper;

import com.jsp.springboot.rest.api.user.dto.UserDto;
import com.jsp.springboot.rest.api.user.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AutoUserMapper {

    AutoUserMapper MAPPER = Mappers.getMapper(AutoUserMapper.class);

    UserDto userToUserDto(User user);
    User userDtoToUser(UserDto userDto);
}
