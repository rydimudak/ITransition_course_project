package com.example.tshirtshop.Repos;

import com.example.tshirtshop.Entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
    User findByUsername(String username);
}