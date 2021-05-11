package com.example.demo.controller;

import com.example.demo.models.Post;

import com.example.demo.repositories.PostRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {

    //dependency injection where we create a Repository instance and initialize it in the controller class constructor.
    private final PostRepository postsDao;

    public PostController(PostRepository postsDao) {
        this.postsDao = postsDao;
    }

    @GetMapping("/posts")
    public String postsMethod (Model model) {
        model.addAttribute("posts", postsDao.findAll());
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String getOneId (@PathVariable long id, Model model) {
        Post post = postsDao.getOne(id);
        model.addAttribute("post", post);
        return "posts/show";
    }

    @GetMapping("/posts/{id}/edit")
    public String edit (@PathVariable long id, Model model) {
        model.addAttribute("posts", postsDao.getOne(id));
        return "posts/edit";
    }

    @PostMapping("/posts/{id}/edit")
    public String update (@PathVariable long id, @RequestParam(name = "title") String title,@RequestParam(name = "body") String body) {
        Post postToUpdate = new Post(
                id, title, body);
        postsDao.save(postToUpdate);
        return "redirect:/posts";
    }

    @PostMapping("/posts/{id}/delete")
    public String delete(@PathVariable long id) {
        postsDao.deleteById(id);
        return "redirect:/posts";
    }

}
