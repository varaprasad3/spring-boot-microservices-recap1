package com.jsp.springboot.rest.api.user.controller;

import com.jsp.springboot.rest.api.user.entity.User;
import com.jsp.springboot.rest.api.user.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("api/users")
public class UserController {

    private UserService userService;

    //build create user REST API
    @PostMapping
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        User savedUser = userService.saveUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    //build find user by id
    @GetMapping("{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Integer userId) {
        User user = userService.getUserById(userId) ;
        return new ResponseEntity<> (user, HttpStatus.OK) ;
    }
}
