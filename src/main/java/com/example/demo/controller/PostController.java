package com.example.demo.controller;

import com.example.demo.models.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class PostController {

    @GetMapping("/posts")
    public String postsMethod (Model model) {
        ArrayList<Post> post = new ArrayList<>();
        post.add(new Post(1,"First Post Title","First Post Body"));
        post.add(new Post(2,"Second Post Title","Second Post Body"));
        post.add(new Post(3,"Third Post Title","Third Post Body"));
        model.addAttribute("posts", post);
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String postId (@PathVariable int id, Model model) {
        Post post = new Post(id,"Post Title","Post Body");
        model.addAttribute("id", id);
        model.addAttribute("post", post);
        return "posts/show";
    }

    @GetMapping("/posts/create")
    public String createPost () {
        return "FORM";
    }

    @PostMapping( path = "/posts/create")
    public String postId () {
        return "Your post will be submiting";
    }
}
