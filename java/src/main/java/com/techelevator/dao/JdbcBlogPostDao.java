package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.BlogPost;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;

public class JdbcBlogPostDao implements BlogPostDao {

    private JdbcTemplate jdbcTemplate;

    //TODO Update the DataSource name to cartoonism for this project?
    public JdbcBlogPostDao(DataSource final_capstone) {
        this.jdbcTemplate = new JdbcTemplate(final_capstone);
    }

    public BlogPost getBlogPostById(int blogPostId) {
        BlogPost blogPost = null;
        String sql = "SELECT blogpost_id, blogpost_name, blogpost_author, blogpost_description, post_date, blogpost_content, " +
                "image_name, image_url, created_at, updated_at " +
                "FROM blogposts WHERE blogpost_id = 1";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, blogPostId);

        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database.", e);
        }
        return blogPost;
    }
}
