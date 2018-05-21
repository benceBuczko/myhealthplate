package com.codecool.healthplate.services;

import com.codecool.healthplate.models.User;
import com.codecool.healthplate.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public void saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    public User getUserByEmail(String email){
        return userRepository.getUserByEmail(email);
    }

    //Harris-Benedict
    public double calculateEnergyIntake(boolean isMale, int age, int weight, int height, double activity ){
        if(isMale){
            return (66.5 + (13.8 * weight) + (5 * height) - (6.8 * age)) * activity;
        } else {
            return (665 + (9.6 * weight) + (1.9 * height) - (4.7 * age)) * activity;
        }
    }
}
