package com.example.tshirtshop.Services;

import com.example.tshirtshop.Entities.UserEntity;
import com.example.tshirtshop.Models.User;
import com.example.tshirtshop.Repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void registerNewMember(User user) {
        UserEntity entity = new UserEntity(user.getUsername(), user.getPassword(), user.getName(), user.getSurname(), user.getLastName(), user.getEmail());
        userRepository.save(entity);
    }

}
