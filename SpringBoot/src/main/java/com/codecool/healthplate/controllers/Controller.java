package com.codecool.healthplate.controllers;

import com.codecool.healthplate.models.User;
import com.codecool.healthplate.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Map;

@RestController
@Scope("session")
public class Controller {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model, Principal principal) {
        User user = (principal == null) ? null : userService.getUserByEmail(principal.getName());
        model.addAttribute("user", user);
        return "index";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(@RequestParam  Map<String, String> user ) {
        User check = userService.getUserByEmail( user.get("email") );
        if (check == null) {
            User userToSave = new User(user.get("name"),user.get("password"),user.get("email"));
            userService.saveUser(userToSave);
            return "true";
        }
        return "false";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestParam  Map<String, String> user ) {
        User check = userService.getUserByEmail( user.get("email") );
        if (check == null) {
            return "false";
        } else if(new BCryptPasswordEncoder().matches(user.get("password"),check.getPassword())){
            return check.getUserName();
        }
        return "false";
    }

}
