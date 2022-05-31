package com.example.demo.controller;

import com.example.demo.domain.MyUser;
import com.example.demo.security.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@RestController
public class UserController {

    private final MyUserDetailsService userDetailsService;

    @Autowired
    public UserController(MyUserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @GetMapping(value = "")
    public List<MyUser> getUserByUsername() {
        return Arrays.asList(
                new MyUser(1, "User1", "user1@test.com"),
                new MyUser(2, "User2", "user2@test.com"),
                new MyUser(3, "User3", "user3@test.com"));
    }
}
