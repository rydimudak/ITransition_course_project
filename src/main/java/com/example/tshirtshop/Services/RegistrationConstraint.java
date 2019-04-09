package com.example.tshirtshop.Services;

import com.example.tshirtshop.Models.User;

public interface RegistrationConstraint {

    boolean registrationAllowed(User user);
}
