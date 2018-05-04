package com.codecool.healthplate.controllers;

import com.codecool.healthplate.models.User;
import com.codecool.healthplate.services.UserService;
import com.google.gson.JsonObject;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Map;

@CrossOrigin
@RestController
public class Controller {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model, Principal principal) {
        User user = (principal == null) ? null : userService.getUserByEmail(principal.getName());
        model.addAttribute("user", user);
        return "index";
    }

    @RequestMapping(value = "/loginsuccess", method = RequestMethod.GET)
    public String loginsuccess(Principal principal) {
        String username = (principal == null) ? null : userService.getUserByEmail(principal.getName()).getUserName();
        return username;
    }

    @RequestMapping(value = "/loginfail", method = RequestMethod.GET)
    public String loginfail() {
        return "fail";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(@RequestParam Map<String,String> user) {
        User userToSave = new User(user.get("username"),user.get("password"),user.get("email"));
        userService.saveUser(userToSave);
        return "redirect:/";
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String userPage(Model model, Principal principal) {
        User user = (principal == null) ? null : userService.getUserByEmail(principal.getName());
        model.addAttribute("user", user);
        return "user";
    }


}
