package com.example.demo.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String body;

    @OneToOne(cascade = CascadeType.ALL)
    private PostDetails postDetails;

    /**
     * @OneToMany is on the side that doesn't contain the foreign key
     * - the cascade allows us to CRUD images through ads
     * - the mappedBy prevents an unneeded mapping table to be created by Hibernate
     * - the orphanRemoval will automatically delete any images if they are removed from an ad
     */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "post", orphanRemoval = true)
    private List<PostImage> postImages;

    @ManyToOne
    private User user;


    public Post() {
    }

    public Post(long id, String title, String body) {
        this.id = id;
        this.title = title;
        this.body = body;
    }

    public Post(String title, String body) {
        this.title = title;
        this.body = body;
    }

    public Post(long id, String title, String body, PostDetails postDetails) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.postDetails = postDetails;
    }

    public Post(long id, String title, String body, List<PostImage> postImages) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.postImages = postImages;
    }

    public Post(long id, String title, String body, User user) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.user = user;
    }

    public Post(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public PostDetails getPostDetails() {
        return postDetails;
    }

    public void setPostDetails(PostDetails postDetails) {
        this.postDetails = postDetails;
    }

    public List<PostImage> getPostImages() {
        return postImages;
    }

    public void setPostImages(List<PostImage> postImages) {
        this.postImages = postImages;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
