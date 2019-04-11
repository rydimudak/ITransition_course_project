package com.example.tshirtshop.Services;

import com.example.tshirtshop.Entities.UserEntity;
import com.example.tshirtshop.Exceptions.RegistrationFailedException;
import com.example.tshirtshop.Models.Role;
import com.example.tshirtshop.Models.User;
import com.example.tshirtshop.Repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RegistrationConstraint registrationConstraint;

    public void registerNewMember(User user) throws RegistrationFailedException {

        if (registrationConstraint.registrationAllowed(user)) {
            UserEntity entity = new UserEntity(user.getUsername(), user.getPassword(), user.getName(), user.getSurname(), user.getLastName(), user.getEmail());
            entity.setRoles(Collections.singleton(Role.USER));
            //TODO: REWORK SUBMISSION
                entity.setActive(true);
            //
            userRepository.save(entity);
        }
        else {
            throw new RegistrationFailedException();
        }
    }

    public void deleteMember(User user) {
        UserEntity entity = new UserEntity(user.getUsername(), user.getPassword(), user.getName(), user.getSurname(), user.getLastName(), user.getEmail());
        userRepository.delete(entity);
    }

}
