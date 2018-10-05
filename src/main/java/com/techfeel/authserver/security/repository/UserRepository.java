package com.techfeel.authserver.security.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

import com.techfeel.authserver.security.model.Users;

public interface UserRepository extends JpaRepository<Users, Integer> {
    Optional<Users> findByName(String username);
}
