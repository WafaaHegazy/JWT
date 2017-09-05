package com.jwtexample.jwt.config.userRepoImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.jwtexample.jwt.config.user.User;
import com.jwtexample.jwt.config.userRepoInt.UserRepositoryInt;

@Service
public class UserRepositoryImpl implements UserDetailsService {

    @Autowired
    private UserRepositoryInt userRepository;

    @Override
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
        final User user = userRepository.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException(String.format("No user found with username '%s'.", username));
        } else {
            return user;
        }
    }
}
