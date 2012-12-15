CREATE TABLE user (
	username VARCHAR(200) NOT NULL,
	PRIMARY KEY (username)
);

CREATE TABLE items (
	id BIGINT IDENTITY NOT NULL,
	name VARCHAR(200) NOT NULL,
	username VARCHAR(200) NOT NULL
);

ALTER TABLE items
	ADD FOREIGN KEY (username) 
	REFERENCES user (username);
	
INSERT INTO user(username) VALUES ('admin');
INSERT INTO user(username) VALUES ('beku');
INSERT INTO user(username) VALUES ('koala');

INSERT INTO items(id, name, username) VALUES (1, 'nokia 3310', 'beku');
INSERT INTO items(id, name, username) VALUES (2, 'acer notebook', 'beku');
INSERT INTO items(id, name, username) VALUES (3, 'ipad 3', 'admin');
