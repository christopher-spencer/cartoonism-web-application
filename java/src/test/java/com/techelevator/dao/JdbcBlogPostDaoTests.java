package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.BlogPost;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
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

        Assert.assertNotNull(blogPost);
    }

    @Test
    public void getBlogPostById_returns_null_for_nonexistent_blogpost() {
        BlogPost blogPost = sut.getBlogPostById(7);

        Assert.assertNull(blogPost);
    }

    @Test
    public void getBlogPostById_returns_correct_blogpost_by_id() {
        BlogPost blogPost = sut.getBlogPostById(1);

        Assert.assertEquals(1, blogPost.getBlogPostId());
    }

    @Test
    public void getBlogPostById_throws_CannotGetJdbcConnectionException_if_fed_wrong_datasource() {
        DataSource incorrectDataSource = mock(DataSource.class);

        JdbcBlogPostDao daoWithIncorrectDataSource = new JdbcBlogPostDao(incorrectDataSource);

        Assert.assertThrows(DaoException.class, () -> {
            daoWithIncorrectDataSource.getBlogPostById(1);
        });
    }

    @Test
    public void getBlogPosts_returns_all_blogposts() {
        List<BlogPost> blogPosts = sut.getBlogPosts();

        Assert.assertNotNull(blogPosts);
        Assert.assertFalse(blogPosts.isEmpty());
    }
}
