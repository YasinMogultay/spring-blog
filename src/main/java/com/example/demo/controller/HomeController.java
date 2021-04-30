package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {

    @GetMapping("/")
    @ResponseBody
    public String landingPage() {
        return "This is a landing Page!";
    }

    @GetMapping("/home/{name}")
    public String welcome(@PathVariable String name, Model model) {
        model.addAttribute("name", name);
        return "home";
    }

}
