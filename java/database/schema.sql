BEGIN TRANSACTION;

DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS blogposts;

CREATE TABLE users (
	user_id SERIAL,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

CREATE TABLE blogposts (
	blogpost_id SERIAL,
	blogpost_name varchar(50) NOT NULL UNIQUE,
	blogpost_author varchar (50),
	blogpost_description varchar(300),
	post_date date,
	blogpost_content varchar(5000),
	image_name varchar(50),
	image_url varchar(512),
	upload_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	CONSTRAINT PK_blogpost PRIMARY KEY (blogpost_id)
);

COMMIT TRANSACTION;
