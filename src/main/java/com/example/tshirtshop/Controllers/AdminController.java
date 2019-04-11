package com.example.tshirtshop.Controllers;

import com.example.tshirtshop.Entities.UserEntity;
import com.example.tshirtshop.Repos.UserRepository;
import com.example.tshirtshop.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @GetMapping("/admin")
    public String admin(Model model) {
        Iterable<UserEntity> users = userRepository.findAll();
        model.addAttribute("users", users);
        return "admin";
    }

    @PostMapping("deleting")
    public String admin(@RequestParam("userId") UserEntity[] users, Model model) {

        for (UserEntity user: users) {
            userRepository.delete(user);
        }

        Iterable<UserEntity> _users = userRepository.findAll();
        model.addAttribute("users", _users);

        return "admin";
    }

}
