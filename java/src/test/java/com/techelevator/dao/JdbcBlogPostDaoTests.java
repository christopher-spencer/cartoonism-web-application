package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.BlogPost;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.mock;

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

        Assert.assertNotNull("getBlogPostById did not return valid blog post for valid ID", blogPost);
    }

    @Test
    public void getBlogPostById_returns_null_for_nonexistent_blogpost() {
        BlogPost blogPost = sut.getBlogPostById(7);

        Assert.assertNull("getBlogPostById did not return null for nonexistent blog post", blogPost);
    }

    @Test
    public void getBlogPostById_returns_correct_blogpost_by_id() {
        BlogPost blogPost = sut.getBlogPostById(1);

        Assert.assertEquals("getBlogPostById did not return expected ID", 1, blogPost.getBlogPostId());
    }

    @Test
    public void getBlogPostById_throws_CannotGetJdbcConnectionException_if_fed_wrong_datasource() {
        DataSource incorrectDataSource = mock(DataSource.class);

        JdbcBlogPostDao daoWithIncorrectDataSource = new JdbcBlogPostDao(incorrectDataSource);

        Assert.assertThrows("getBlogPostById did not throw CannotGetJdbcConnectionException when fed the wrong Datasource", DaoException.class, () -> {
            daoWithIncorrectDataSource.getBlogPostById( 1);
        });
    }

    @Test
    public void getBlogPosts_returns_all_blogposts() {
        List<BlogPost> blogPosts = sut.getBlogPosts();

        Assert.assertNotNull(blogPosts);
        Assert.assertFalse("getBlogPosts did not return all blog posts", blogPosts.isEmpty());
    }

    @Test
    public void addBlogPost_creates_a_new_blogpost() {
        BlogPost blogPost = new BlogPost();
        blogPost.setBlogPostName("Test Blog Post");

        BlogPost createdBlogPost = sut.addBlogPost(blogPost);

        Assert.assertNotNull("addBlogPost did not create a new blog post", createdBlogPost);
    }


}
