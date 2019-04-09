package com.example.tshirtshop.Controllers;

import com.example.tshirtshop.Exceptions.RegistrationFailedException;
import com.example.tshirtshop.Models.User;
import com.example.tshirtshop.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping(path = "/registration")
public class RegistrationController {
    @Autowired
    private UserService userService;

    @GetMapping
    public String registration() {
        return "registration";
    }

    @PostMapping
    public String addUser(@ModelAttribute @Valid User user, BindingResult result, Model model) throws RegistrationFailedException{

        if (result.hasErrors()) {
            model.addAttribute("error", "Some of the fields have invalid values");
            return "/registration";
        }
        else {
            userService.registerNewMember(user);
            return "redirect:/login";
        }
    }

}
