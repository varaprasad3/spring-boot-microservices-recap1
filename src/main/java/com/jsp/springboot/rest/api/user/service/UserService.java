package com.jsp.springboot.rest.api.user.service;

import com.jsp.springboot.rest.api.user.dto.UserDto;
import com.jsp.springboot.rest.api.user.entity.User;

import java.util.List;

public interface UserService {
    public UserDto saveUser(UserDto user);

    public UserDto getUserById(Integer id);

    public List<UserDto> getAllUsers();

    public UserDto updateUser(UserDto user);

    public void deleteUser(Integer id) ;
}
