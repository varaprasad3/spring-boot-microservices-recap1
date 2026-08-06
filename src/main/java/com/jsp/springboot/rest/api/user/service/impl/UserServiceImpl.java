package com.jsp.springboot.rest.api.user.service.impl;

import com.jsp.springboot.rest.api.user.dto.UserDto;
import com.jsp.springboot.rest.api.user.dto.UserMapper;
import com.jsp.springboot.rest.api.user.entity.User;
import com.jsp.springboot.rest.api.user.repository.UserRepository;
import com.jsp.springboot.rest.api.user.service.UserService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Override
    public UserDto saveUser(UserDto userDto) {

        User user = UserMapper.mapUserDtoToUser(userDto);

        User savedUser = userRepository.save(user);

        UserDto savedUserDto = UserMapper.mapUserToUserDto(savedUser);

        return savedUserDto;
    }

    @Override
    public UserDto getUserById(Integer id) {
        Optional<User> optionalUser = userRepository.findById(id);
        User user = optionalUser.get();
        UserDto userDto = UserMapper.mapUserToUserDto(user);
        return userDto;
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map(UserMapper::mapUserToUserDto).
                collect(Collectors.toList());
    }

    @Override
    public UserDto updateUser(UserDto userDto) {
        User existingUser = userRepository.findById(userDto.getId()).get();
        existingUser.setFirstName(userDto.getFirstName());
        existingUser.setLastName(userDto.getLastName());
        existingUser.setEmail(userDto.getEmail());

        User updatedUser = userRepository.save(existingUser);
        return UserMapper.mapUserToUserDto(updatedUser);
    }

    @Override
    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }
}
