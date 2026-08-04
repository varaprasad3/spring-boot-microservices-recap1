package com.jsp.springboot.rest.api.user.repository;

import com.jsp.springboot.rest.api.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
}
