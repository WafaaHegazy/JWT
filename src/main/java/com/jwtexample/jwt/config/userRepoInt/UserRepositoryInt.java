package com.jwtexample.jwt.config.userRepoInt;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jwtexample.jwt.config.user.User;

public interface UserRepositoryInt extends JpaRepository<User, Long> {

    User findByUsername(String username);

}
