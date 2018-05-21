package com.codecool.healthplate.controllers;

import com.codecool.healthplate.models.User;
import com.codecool.healthplate.services.UserService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Map;

import static java.lang.Boolean.parseBoolean;
import static java.lang.Integer.parseInt;

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
            Gson gson = new Gson();
            return gson.toJson(check);
        }
        return "false";
    }

    @RequestMapping(value = "/user/update", method = RequestMethod.POST)
    public String update(@RequestParam  Map<String, String> data ){
        User user = userService.getUserByEmail( data.get("email") );
        user.setAge(parseInt(data.get("age")));
        user.setHeight(parseInt(data.get("height")));
        user.setWeight(parseInt(data.get("weight")));
        user.setGender(parseBoolean(data.get("gender")));
        user.setActivity(parseInt(data.get("activity")));

        double activity = 1.2;
        switch (user.getActivity()){
            case 1: activity = 1.2;
                    break;
            case 2: activity = 1.5;
                break;
            case 3: activity = 1.7;
                break;
            case 4: activity = 2;
                break;
        }
        user.setEnergy(userService.calculateEnergyIntake(user.isGender(),user.getAge(),user.getWeight(),user.getHeight(),activity));
        userService.saveUser(user);
        Gson gson = new Gson();
        return gson.toJson(user);
    }

}
