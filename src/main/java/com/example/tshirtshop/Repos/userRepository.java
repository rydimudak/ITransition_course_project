package com.example.tshirtshop.Repos;

import com.example.tshirtshop.Entities.User;
import org.springframework.data.repository.CrudRepository;

public interface userRepository extends CrudRepository<User, Integer> {
    User findbyUsername(String username);
}
