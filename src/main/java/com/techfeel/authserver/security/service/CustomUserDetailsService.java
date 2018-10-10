package com.techfeel.authserver.security.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.techfeel.authserver.security.model.CustomUserDetails;
import com.techfeel.authserver.security.model.Users;
import com.techfeel.authserver.security.repository.*;

/**
 * 
 * @author bhavesh bhatt
 *
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository usersRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<Users> usersOptional = usersRepository.findByName(username);

        usersOptional
                .orElseThrow(() -> new UsernameNotFoundException("Username not found!"));
        return usersOptional
                .map(CustomUserDetails::new)
                .get();
    }
}
