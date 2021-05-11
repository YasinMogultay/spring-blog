package com.example.demo.repositories;

import com.example.demo.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PostRepository extends JpaRepository<Post,Long> { //always extend from JpaRepository for injection with object that you have and type of your id
    Post findByTitle(String title);
}
