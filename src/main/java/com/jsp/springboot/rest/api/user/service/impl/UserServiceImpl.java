package com.jsp.springboot.rest.api.user.service.impl;

import com.jsp.springboot.rest.api.user.dto.UserDto;
import com.jsp.springboot.rest.api.user.entity.User;
import com.jsp.springboot.rest.api.user.exception.EmailAlreadyExistsException;
import com.jsp.springboot.rest.api.user.exception.ResourceNotFoundException;
import com.jsp.springboot.rest.api.user.mapper.AutoUserMapper;
import com.jsp.springboot.rest.api.user.repository.UserRepository;
import com.jsp.springboot.rest.api.user.service.UserService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    private ModelMapper modelMapper;

    @Override
    public UserDto saveUser(UserDto userDto) {

        //  User user = UserMapper.mapUserDtoToUser(userDto);
        //  User user = modelMapper.map(userDto, User.class) ;

        Optional<User> optionalUser = userRepository.findByEmail(userDto.getEmail()) ;

        if (optionalUser.isPresent()) {
            throw new EmailAlreadyExistsException("User already exists");
        }

        User user = AutoUserMapper.MAPPER.userDtoToUser(userDto);

        User savedUser = userRepository.save(user);

        //  UserDto savedUserDto = UserMapper.mapUserToUserDto(savedUser);
        //  UserDto savedUserDto = modelMapper.map(savedUser, UserDto.class);

        UserDto savedUserDto = AutoUserMapper.MAPPER.userToUserDto(savedUser);
        return savedUserDto;
    }

    @Override
    public UserDto getUserById(Integer id) {
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "id", id));

        //  UserDto userDto = UserMapper.mapUserToUserDto(user);
//        UserDto userDto = modelMapper.map(user, UserDto.class);
        UserDto userDto = AutoUserMapper.MAPPER.userToUserDto(user);
        return userDto;
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();
//        return users.stream().map(UserMapper::mapUserToUserDto).
//                collect(Collectors.toList());
//        return users.stream().map(user -> modelMapper.map(user, UserDto.class))
//                .collect(Collectors.toList());
        return users.stream().map(user -> AutoUserMapper.MAPPER.userToUserDto(user))
                .collect(Collectors.toList());
    }

    @Override
    public UserDto updateUser(UserDto userDto) {
        User existingUser = userRepository.findById(userDto.getId()).orElseThrow(() -> new ResourceNotFoundException("User", "id", userDto.getId()));
        existingUser.setFirstName(userDto.getFirstName());
        existingUser.setLastName(userDto.getLastName());
        existingUser.setEmail(userDto.getEmail());

        User updatedUser = userRepository.save(existingUser);
        // return UserMapper.mapUserToUserDto(updatedUser);
//        return modelMapper.map(updatedUser, UserDto.class);
        return AutoUserMapper.MAPPER.userToUserDto(updatedUser);
    }

    @Override
    public void deleteUser(Integer id) {
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
        userRepository.deleteById(id);
    }
}
