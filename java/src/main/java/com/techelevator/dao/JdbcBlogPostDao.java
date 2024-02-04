package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.BlogPost;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcBlogPostDao implements BlogPostDao {

    private JdbcTemplate jdbcTemplate;

    //TODO could be cool to add video blog option eventually as well

    //TODO Update the DataSource name to cartoonism for this project?
    public JdbcBlogPostDao(DataSource final_capstone) {
        this.jdbcTemplate = new JdbcTemplate(final_capstone);
    }

    public List<BlogPost> getBlogPosts() {
        List<BlogPost> blogPosts = new ArrayList<>();
        String sql = "SELECT blogpost_id, blogpost_name, blogpost_author, blogpost_description, post_date, blogpost_content, " +
                "image_name, image_url, created_at, updated_at " +
                "FROM blogposts;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            BlogPost blogPost = mapRowToBlogPost(results);
            blogPosts.add(blogPost);
        }
        
        return blogPosts;
    }

    public BlogPost getBlogPostById(int blogPostId) {
        BlogPost blogPost = null;
        String sql = "SELECT blogpost_id, blogpost_name, blogpost_author, blogpost_description, post_date, blogpost_content, " +
                "image_name, image_url, created_at, updated_at " +
                "FROM blogposts WHERE blogpost_id = ?";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, blogPostId);
            if (results.next()) {
                blogPost = mapRowToBlogPost(results);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database.", e);
        }
        return blogPost;
    }

    private BlogPost mapRowToBlogPost(SqlRowSet rs) {
        BlogPost blogPost = new BlogPost();

        blogPost.setBlogPostId(rs.getInt("blogpost_id"));
        blogPost.setBlogPostName(rs.getString("blogpost_name"));
        blogPost.setBlogPostAuthor(rs.getString("blogpost_author"));
        blogPost.setBlogPostDescription(rs.getString("blogpost_description"));
        blogPost.setPostDate(rs.getDate("post_date"));
        blogPost.setBlogPostContent(rs.getString("blogpost_content"));
        blogPost.setImageName(rs.getString("image_name"));
        blogPost.setImageUrl(rs.getString("image_url"));
        blogPost.setCreatedAt(rs.getDate("created_at"));
        blogPost.setUpdatedAt(rs.getDate("updated_at"));

        return blogPost;
    }
}
