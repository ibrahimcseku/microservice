CREATE TABLE users (
    id 				int,
    username 		varchar(56),
    password 		varchar(256),
    PRIMARY KEY (id)

);

CREATE TABLE user_roles (
    userid 	int,
    roleid 	int,
	PRIMARY KEY (userid,roleid)
);

CREATE TABLE roles (
	id 			int,
    name 		varchar(56),
	PRIMARY KEY (id)
);

INSERT INTO roles(id,name) VALUES(1,'ROLE_USER');
INSERT INTO roles(id,name) VALUES(2,'ROLE_ADMIN');