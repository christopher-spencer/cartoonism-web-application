package com.techelevator.controller;

import com.techelevator.dao.BlogPostDao;
import com.techelevator.exception.DaoException;
import com.techelevator.model.BlogPost;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@CrossOrigin
@RestController
//@PreAuthorize("isAuthenticated()")
public class BlogPostController {

    private BlogPostDao blogPostDao;

    public BlogPostController(BlogPostDao blogPostDao) {
        this.blogPostDao = blogPostDao;
    }

    //Annotation option besides @RequestMapping
    @GetMapping(path="/blogposts")
    public List<BlogPost> getBlogPosts() {
        return blogPostDao.getBlogPosts();
    }

    @RequestMapping (path = "/blogposts/{blogPostId}", method = RequestMethod.GET)
    public BlogPost getBlogPost(@PathVariable int blogPostId) {
        BlogPost blogPost = blogPostDao.getBlogPostById(blogPostId);
        return blogPost;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(path="/blogpost/create-blogpost")
    public BlogPost addBlogPost(@RequestBody BlogPost blogPost) {
        return blogPostDao.addBlogPost(blogPost);
    }

    @PutMapping(path="/update-blogpost/{blogPostId}")
    public BlogPost updateBlogPost(@RequestBody BlogPost blogPost, @PathVariable int blogPostId) {
        blogPost.setId(blogPostId);

        try {
            BlogPost updatedBlogPost = blogPostDao.updateBlogPost(blogPost);
            return updatedBlogPost;
        } catch (DaoException e) {
            if (e.getMessage().equals("Zero rows affected, expected at least one update.")) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Blog post not found.");
            } else {
                throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Failed to update blog post.", e);
            }
        }
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(path = "/blogpost/delete/{blogPostId}")
    public void removeBlogPostByBlogPostId(@PathVariable int blogPostId) {
        blogPostDao.removeBlogPostByBlogPostId(blogPostId);
    }
}
