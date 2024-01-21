package com.scaler.userservice.controller;

import com.scaler.userservice.entites.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/details/{userid}")
    public User userDetails(@PathVariable int userid){
        User user = new User();
        user.setUserId(userid);
        user.setUsername("Shubham Mishra");
        if(userid%2==0){
            user.setRole("User");
        }else{
            user.setRole("Admin");
        }
        return user;
    }
}
