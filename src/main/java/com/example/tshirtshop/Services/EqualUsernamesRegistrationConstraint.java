package com.example.tshirtshop.Services;

import com.example.tshirtshop.Models.User;
import com.example.tshirtshop.Repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EqualUsernamesRegistrationConstraint implements RegistrationConstraint {

    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean registrationAllowed(User user) {
        return (userRepository.findByUsername(user.getUsername()) == null);
    }
}
