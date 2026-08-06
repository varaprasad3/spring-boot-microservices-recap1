package com.jsp.springboot.rest.api.user.repository;

import com.jsp.springboot.rest.api.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Integer> {
    Optional<User> findByEmail(String email) ;
}
