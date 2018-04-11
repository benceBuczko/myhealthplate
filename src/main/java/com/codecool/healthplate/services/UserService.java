package com.codecool.healthplate.services;

import com.codecool.healthplate.models.User;
import com.codecool.healthplate.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public void saveUser(User user) {
        userRepository.save(user);
    }

    public User getUserByEmail(String email){
        return userRepository.getUserByEmail(email);
    }
}
