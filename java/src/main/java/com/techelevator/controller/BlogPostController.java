package com.techelevator.controller;

import com.techelevator.dao.BlogPostDao;
import com.techelevator.model.BlogPost;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
//@PreAuthorize("isAuthenticated()")
public class BlogPostController {

    private BlogPostDao blogPostDao;

    public BlogPostController(BlogPostDao blogPostDao) {
        this.blogPostDao = blogPostDao;
    }

    @RequestMapping (path = "/blogposts/{blogPostId}", method = RequestMethod.GET)
    public BlogPost getBlogPost(@PathVariable int blogPostId) {
        BlogPost blogPost = blogPostDao.getBlogPostById(blogPostId);
        return blogPost;
    }
}
