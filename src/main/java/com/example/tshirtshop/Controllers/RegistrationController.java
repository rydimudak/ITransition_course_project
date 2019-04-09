package com.example.tshirtshop.Controllers;

import com.example.tshirtshop.Entities.UserEntity;
import com.example.tshirtshop.Models.User;
import com.example.tshirtshop.Repos.UserRepository;
import com.example.tshirtshop.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping(path = "/registration")
public class RegistrationController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @GetMapping
    public String registration() {
        return "registration";
    }

    @PostMapping
    public String addUser(@ModelAttribute @Valid User user, Model model) {

        UserEntity userFromDb = userRepository.findByUsername(user.getUsername());
        if (userFromDb != null) {
            model.addAttribute("message", true);
            return "/registration";
        }

        userService.registerNewMember(user);

        return "redirect:/login";
    }
}
