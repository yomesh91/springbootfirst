package com.example.springboot.controller;

import com.example.springboot.dao.UserRepository;
import com.example.springboot.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/demo")
public class HelloController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping(path = "/add")
    @ResponseBody
    public  String addNewUser(@RequestParam String name,@RequestParam String email) {

        User user = new User();
        user.setName(name);
        user.setEmail(email);
        userRepository.save(user);
        return "Saved";
    }

        @GetMapping(path = "/all")
        @ResponseBody
        public Iterable<User> getAllUsers(){
            return userRepository.findAll();
        }
    }
