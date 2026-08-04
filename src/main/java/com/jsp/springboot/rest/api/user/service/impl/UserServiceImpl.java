package com.jsp.springboot.rest.api.user.service.impl;

import com.jsp.springboot.rest.api.user.entity.User;
import com.jsp.springboot.rest.api.user.repository.UserRepository;
import com.jsp.springboot.rest.api.user.service.UserService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

  private  UserRepository userRepository ;

    @Override
    public User saveUser(User user) {
          return userRepository.save(user) ;
    }

    @Override
    public User getUserById(Integer id) {
        Optional<User> optionalUser = userRepository.findById(id) ;
        return optionalUser.get() ;
    }
}
