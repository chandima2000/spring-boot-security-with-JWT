package org.chandima.springsecurityapp.repository;

import org.chandima.springsecurityapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String username);
}
