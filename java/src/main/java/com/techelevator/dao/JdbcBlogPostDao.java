package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.BlogPost;
import org.springframework.dao.DataIntegrityViolationException;
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
    public JdbcBlogPostDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<BlogPost> getBlogPosts() {
        List<BlogPost> blogPosts = new ArrayList<>();
        String sql = "SELECT blogpost_id, blogpost_name, blogpost_author, blogpost_description, blogpost_content, " +
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
        String sql = "SELECT blogpost_id, blogpost_name, blogpost_author, blogpost_description, blogpost_content, " +
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

    public BlogPost addBlogPost(BlogPost blogPost) {
        BlogPost newBlogPost = null;
        String sql = "INSERT into blogposts (blogpost_name, blogpost_author, blogpost_description, blogpost_content, " +
                "image_name, image_url) " +
                "VALUES (?,?,?,?,?,?) " +
                "RETURNING blogpost_id;";

        try {
            if (blogPost.getName() == null) {
                throw new IllegalArgumentException("Blog post name cannot be null");
            }
            // In Java, primitive types are not nullable, meaning they cannot have a null value.
            // However, objects, including instances of wrapper classes like Integer, can be null.
            // Used Wrapper first, then unboxed it after checking if it's null to avoid NullPointerException
            Integer newBlogPostIdWrapper = jdbcTemplate.queryForObject(sql, Integer.class, blogPost.getName(),
                    blogPost.getAuthor(), blogPost.getDescription(), blogPost.getContent(),
                    blogPost.getImageName(), blogPost.getImageUrl());

            if (newBlogPostIdWrapper != null) {
                int newBlogPostId = newBlogPostIdWrapper;
                newBlogPost = getBlogPostById(newBlogPostId);
            } else {
                System.out.println("The query returned a null value for newBlogPostIdWrapper. Handle appropriately.");
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data Integrity Violation", e);
        }

        return newBlogPost;
    }

//    public BlogPost addBlogPostByUserId(int userId, BlogPost blogPost) {
//
//    }
    
    public BlogPost updateBlogPost(BlogPost blogPost) {
        BlogPost updatedBlogPost = null;
        String sql = "UPDATE blogposts SET blogpost_name = ?, blogpost_author = ?, blogpost_description = ?, " +
                "blogpost_content = ?, image_name = ?, image_url = ? " +
                "WHERE blogpost_id = ?;";

        try {
            int numberOfRows = jdbcTemplate.update(sql, blogPost.getName(), blogPost.getAuthor(),
                    blogPost.getDescription(), blogPost.getContent(), blogPost.getImageName(),
                    blogPost.getImageUrl(), blogPost.getId());

            if (numberOfRows == 0) {
                throw new DaoException("Zero rows affected, expected at least one update.");
            } else {
                updatedBlogPost = getBlogPostById(blogPost.getId());
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database.", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data Integrity Violation.", e);
        }
        return updatedBlogPost;
    }

    public int removeBlogPostByBlogPostId(int blogPostId) {
        int numberOfRows = 0;
        String sql = "DELETE FROM blogposts WHERE blogpost_id = ?;";

        try {
            numberOfRows = jdbcTemplate.update(sql, blogPostId);
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data Integrity Violation.", e);
        }
        return numberOfRows;
    }

    private BlogPost mapRowToBlogPost(SqlRowSet rs) {
        BlogPost blogPost = new BlogPost();

        blogPost.setId(rs.getInt("blogpost_id"));
        blogPost.setName(rs.getString("blogpost_name"));
        blogPost.setAuthor(rs.getString("blogpost_author"));
        blogPost.setDescription(rs.getString("blogpost_description"));
        blogPost.setContent(rs.getString("blogpost_content"));
        blogPost.setImageName(rs.getString("image_name"));
        blogPost.setImageUrl(rs.getString("image_url"));
        blogPost.setCreatedAt(rs.getDate("created_at"));
        blogPost.setUpdatedAt(rs.getDate("updated_at"));

        return blogPost;
    }
}
