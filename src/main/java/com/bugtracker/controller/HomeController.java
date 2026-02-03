package com.bugtracker.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
//
//    @GetMapping("/welcome")
//    public String home() {
//        return "Login successful! Welcome to Bug Tracker.";
//    }

    @GetMapping("/")
    public String home() {
        return "Bug Tracker API Running 🚀";
    }
}