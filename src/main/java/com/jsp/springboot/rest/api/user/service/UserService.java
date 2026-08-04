package com.jsp.springboot.rest.api.user.service;

import com.jsp.springboot.rest.api.user.entity.User;

public interface UserService {
    public User saveUser(User user);

    public User getUserById(Integer id);
}
