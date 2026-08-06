package com.jsp.springboot.rest.api.user.controller;

import com.jsp.springboot.rest.api.user.dto.UserDto;
import com.jsp.springboot.rest.api.user.entity.User;
import com.jsp.springboot.rest.api.user.exception.ErrorDetails;
import com.jsp.springboot.rest.api.user.exception.ResourceNotFoundException;
import com.jsp.springboot.rest.api.user.service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/users")
public class UserController {

    private UserService userService;

    //build create user REST API
    @PostMapping
    public ResponseEntity<UserDto> saveUser(@RequestBody @Valid UserDto user) {
        UserDto savedUserDto = userService.saveUser(user);
        return new ResponseEntity<>(savedUserDto, HttpStatus.CREATED);
    }

    //build find user by id
    @GetMapping("{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable("id") Integer userId) {
        UserDto user = userService.getUserById(userId) ;
        return new ResponseEntity<> (user, HttpStatus.OK) ;
    }

    //get all users by id
    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers() {
        List<UserDto> users = userService.getAllUsers() ;
        return new ResponseEntity<>(users, HttpStatus.OK) ;
    }

    //update Users Rest API
    @PutMapping("{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable Integer id, @RequestBody @Valid UserDto user) {
        user.setId(id);
        UserDto updatedUser = userService.updateUser(user) ;
        return new ResponseEntity<>(updatedUser, HttpStatus.OK) ;
    }

    //Delete User REst API
    @DeleteMapping({"{id}"})
    public ResponseEntity<String> deleteUser(@PathVariable("id") Integer userId)
    {
        userService.deleteUser(userId);
        return new ResponseEntity<> ("User deleted successfully", HttpStatus.OK) ;
    }
}
