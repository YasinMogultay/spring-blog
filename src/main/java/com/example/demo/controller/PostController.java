package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {

    @GetMapping("/posts")
    @ResponseBody
    public String postsMethod () {
        return "posts index page";
    }

    @RequestMapping( path = "/posts/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String postIdd (@PathVariable int id) {
        return "Your post id is " + id;
    }

    @GetMapping("/posts/create")
    @ResponseBody
    public String createPost () {
        return "FORM";
    }

    @RequestMapping( path = "/posts/create", method = RequestMethod.POST)
    @ResponseBody
    public String postIdd () {
        return "Your post will be submiting";
    }
}
