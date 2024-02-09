BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role) VALUES ('user1','user1','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('user2','user2','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('user3','user3','ROLE_USER');

INSERT INTO blogposts (blogpost_id, blogpost_name, blogpost_author, blogpost_description, post_date, blogpost_content, image_name, image_url, created_at, updated_at)
VALUES (1, 'First Blog Post', 'John Doe', 'Description of the first blog post', '2024-02-01', 'Content of the first blog post', 'image1.jpg', 'https://example.com/image1.jpg', '2024-02-01 12:00:00', '2024-02-01 12:00:00');

INSERT INTO blogposts (blogpost_id, blogpost_name, blogpost_author, blogpost_description, post_date, blogpost_content, image_name, image_url, created_at, updated_at)
VALUES (2, 'Second Blog Post', 'Jane Smith', 'Description of the second blog post', '2024-02-02', 'Content of the second blog post', 'image2.jpg', 'https://example.com/image2.jpg', '2024-02-02 12:00:00', '2024-02-02 12:00:00');

INSERT INTO blogposts (blogpost_id, blogpost_name, blogpost_author, blogpost_description, post_date, blogpost_content, image_name, image_url, created_at, updated_at)
VALUES (3, 'Third Blog Post', 'Alice Johnson', 'Description of the third blog post', '2024-02-03', 'Content of the third blog post', 'image3.jpg', 'https://example.com/image3.jpg', '2024-02-03 12:00:00', '2024-02-03 12:00:00');

COMMIT TRANSACTION;
