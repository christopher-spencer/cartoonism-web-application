package com.techelevator.model;

import java.sql.Timestamp;
import java.util.Date;

public class BlogPost {
    private int blogPostId;
    private String blogPostName;
    //TODO if we make this so multiple authors can post better to have an Author Table
    // b/c right now the author will always be me so kinda irrelevant
    private String blogPostAuthor;
    private String blogPostDescription;
    private Date postDate;
    private String blogPostContent;
    private String imageName;
    private String imageUrl;
    private Date createdAt;
    private Date updatedAt;

    public BlogPost(int blogPostId, String blogPostName, String blogPostAuthor, String blogPostDescription,
                    Date postDate, String blogPostContent, String imageName, String imageUrl, Date createdAt, Date updatedAt) {
        this.blogPostId = blogPostId;
        this.blogPostName = blogPostName;
        this.blogPostAuthor = blogPostAuthor;
        this.blogPostDescription = blogPostDescription;
        this.postDate = postDate;
        this.blogPostContent = blogPostContent;
        this.imageName = imageName;
        this.imageUrl = imageUrl;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public int getBlogPostId() {
        return blogPostId;
    }

    public void setBlogPostId(int blogPostId) {
        this.blogPostId = blogPostId;
    }

    public String getBlogPostName() {
        return blogPostName;
    }

    public void setBlogPostName(String blogPostName) {
        this.blogPostName = blogPostName;
    }

    public String getBlogPostAuthor() {
        return blogPostAuthor;
    }

    public void setBlogPostAuthor(String blogPostAuthor) {
        this.blogPostAuthor = blogPostAuthor;
    }

    public String getBlogPostDescription() {
        return blogPostDescription;
    }

    public void setBlogPostDescription(String blogPostDescription) {
        this.blogPostDescription = blogPostDescription;
    }

    public Date getPostDate() {
        return postDate;
    }

    public void setPostDate(Date postDate) {
        this.postDate = postDate;
    }

    public String getBlogPostContent() {
        return blogPostContent;
    }

    public void setBlogPostContent(String blogPostContent) {
        this.blogPostContent = blogPostContent;
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
