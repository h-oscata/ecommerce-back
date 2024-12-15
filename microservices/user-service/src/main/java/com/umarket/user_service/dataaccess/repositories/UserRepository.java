package com.umarket.user_service.dataaccess.repositories;

import com.umarket.user_service.businesslogic.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByEmail(String email);
}
