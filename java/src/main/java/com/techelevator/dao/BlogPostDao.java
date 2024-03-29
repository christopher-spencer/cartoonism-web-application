package com.techelevator.dao;

import com.techelevator.model.BlogPost;

import java.util.List;

public interface BlogPostDao {

    List<BlogPost> getBlogPosts();
    BlogPost getBlogPostById(int blogPostId);
    BlogPost addBlogPost(BlogPost blogPost);
    BlogPost updateBlogPost(BlogPost blogPost);
    int removeBlogPostByBlogPostId(int blogPostId);

}
