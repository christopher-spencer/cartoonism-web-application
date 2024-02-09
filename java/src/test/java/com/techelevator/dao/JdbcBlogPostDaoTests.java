package com.techelevator.dao;

import org.junit.Before;
import org.springframework.jdbc.core.JdbcTemplate;

public class JdbcBlogPostDaoTests extends BaseDaoTests {

    private JdbcBlogPostDao sut;

    @Before
    public void setup() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        sut = new JdbcBlogPostDao(dataSource);
    }

    
}
