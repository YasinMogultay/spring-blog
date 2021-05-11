package com.example.demo.models;

import javax.persistence.*;


@Entity
@Table(name = "post_images")
public class PostImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false,columnDefinition = "VARCHAR(100)")
    private String image_title;

    @Column(nullable = false, columnDefinition = "VARCHAR(1000)")
    private String url;


 /** The @ManyToOne annotation is used on the side with the foreign key */
    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    public PostImage() {
    }

    public PostImage(String image_title, String url, Post post) {
        this.image_title = image_title;
        this.url = url;
        this.post = post;
    }

    public PostImage(long id, String image_title, String url, Post post) {
        this.id = id;
        this.image_title = image_title;
        this.url = url;
        this.post = post;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getImage_title() {
        return image_title;
    }

    public void setImage_title(String image_title) {
        this.image_title = image_title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
}
