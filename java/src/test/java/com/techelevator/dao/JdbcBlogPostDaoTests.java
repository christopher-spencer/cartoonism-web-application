package com.techelevator.dao;

import com.techelevator.model.BlogPost;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

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
}
