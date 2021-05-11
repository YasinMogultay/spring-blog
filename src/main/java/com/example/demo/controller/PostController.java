package com.example.demo.controller;

import com.example.demo.SecurityConfiguration;
import com.example.demo.models.Post;

import com.example.demo.models.User;
import com.example.demo.repositories.PostRepository;
import com.example.demo.repositories.UserRepository;
import com.example.demo.services.EmailService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {

    //dependency injection where we create a Repository instance and initialize it in the controller class constructor.
    private final PostRepository postsDao;
    private final UserRepository usersDao;
    private final EmailService emailService;


    public PostController(PostRepository postsDao, UserRepository usersDao, EmailService emailService) {
        this.postsDao = postsDao;
        this.usersDao = usersDao;
        this.emailService = emailService;
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
        model.addAttribute("post", postsDao.getOne(id));
        return "posts/edit";
    }

    @PostMapping("/posts/{id}/edit")
    public String update (@ModelAttribute Post post) {
        postsDao.save(post);
        return "redirect:/posts";
    }

    @PostMapping("/posts/{id}/delete")
    public String delete(@PathVariable long id) {
        postsDao.deleteById(id);
        return "redirect:/posts";
    }

    //reaching info from postdetails table
    @GetMapping("/posts/details/{id}")
    public String details (@PathVariable long id,Model model) {
        Post post = postsDao.getOne(id);
        model.addAttribute("post", post);
        return"/posts/show";
    }

    //relationships exercise ==== my get and post mapping before Form Model Binding ====
//    @GetMapping("/posts/create")
//    public String create () {
//        return"posts/create";
//    }

    //    @PostMapping("/posts/create")
//    public String createPost(@RequestParam String title, @RequestParam String body) {
//        Post post = new Post(title,body);
//        User user = usersDao.getOne(1L); //'L' make it long data type
//        post.setUser(user);
//        postsDao.save(post);
//        return "redirect:/posts";
//    }

    @GetMapping("/posts/create")
    public String showCreate(Model model) {
        model.addAttribute("post", new Post());
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String create(@ModelAttribute Post post) {
        User author = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        post.setUser(usersDao.getOne(author.getId()));
        postsDao.save(post);
        emailService.prepareAndSend(post,"string subject","string body");
        return "redirect:/posts";
    }



}
