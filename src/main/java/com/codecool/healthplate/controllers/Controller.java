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

@org.springframework.stereotype.Controller
public class Controller {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model, Principal principal) {
        model.addAttribute("user", principal);
        return "index";
    }


    @RequestMapping(value = "/registercheck", method = RequestMethod.POST)
    @ResponseBody
    public String registerCheck(@RequestBody Map<String, String> userEmail, Model model) {
        String email = userEmail.get("userEmail");
        if (userService.getUserByEmail(email) == null) return "true";
        else return "false";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(@RequestParam Map<String,String> user) {
        User userToSave = new User(user.get("username"),user.get("password"),user.get("email"));
        userService.saveUser(userToSave);
        return "redirect:/";
    }


   /* @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public String login(@RequestBody Map<String,String> userparams) {
        User user = userService.getUserByEmail(userparams.get("email"));
        if(user != null && BCrypt.checkpw(userparams.get("password"),user.getPassword())) return "true";
        else return "false";
    }*/

}
