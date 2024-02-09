package com.techelevator.dao;

import com.techelevator.model.BlogPost;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class JdbcBlogPostDaoTests extends BaseDaoTests {

    private JdbcBlogPostDao sut;

    @Before
    public void setup() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        sut = new JdbcBlogPostDao(dataSource);
    }

    @Test
    public void getBlogPostById_returns_blogpost_for_valid_id() {
        BlogPost blogPost = sut.getBlogPostById(1);

        Assert.assertNotNull(blogPost);
    }

    @Test
    public void getBlogPosts_returns_all_blogposts() {
        List<BlogPost> blogPosts = sut.getBlogPosts();

        Assert.assertNotNull(blogPosts);
        Assert.assertFalse(blogPosts.isEmpty());
    }
}
