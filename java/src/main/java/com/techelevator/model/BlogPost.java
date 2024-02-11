package com.techelevator.model;

import java.util.Date;

public class BlogPost {
    private String name;
    private int id;
    //TODO if we make this so multiple authors can post better to have an Author Table
    // b/c right now the author will always be me so kinda irrelevant
    private String author;
    private String description;
    private String content;
    private String imageName;
    private String imageUrl;
    private Date createdAt;
    private Date updatedAt;

    //TODO check out why you just use empty constructor, prob b/c you're setting it up in JdbcBPDao
    public BlogPost() {

    }

    public BlogPost(int id, String name, String author, String description,
                    String content, String imageName, String imageUrl, Date createdAt, Date updatedAt) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.description = description;
        this.content = content;
        this.imageName = imageName;
        this.imageUrl = imageUrl;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}
