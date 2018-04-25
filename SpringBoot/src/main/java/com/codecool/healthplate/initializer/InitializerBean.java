package com.codecool.healthplate.initializer;


import com.codecool.healthplate.models.User;
import com.codecool.healthplate.services.UserService;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class InitializerBean {


    public InitializerBean(UserService us) {
        us.saveUser(new User("11","11","11@11"));
    }
}
