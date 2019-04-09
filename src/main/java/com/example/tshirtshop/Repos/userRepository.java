package com.example.tshirtshop.Repos;

import com.example.tshirtshop.Entities.UserEntity;
import com.example.tshirtshop.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    UserEntity findByUsername(String username);
    Iterable<UserEntity> findAllByRoles(String role);
}