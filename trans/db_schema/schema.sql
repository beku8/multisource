CREATE DATABASE  `trans_db` ;
USE trans_db;

CREATE TABLE  `trans_db`.`user` (
`username` VARCHAR( 200 ) NOT NULL ,
PRIMARY KEY (  `username` )
) ENGINE = INNODB;

CREATE TABLE  `trans_db`.`items` (
`id` BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY ,
`name` VARCHAR( 200 ) NOT NULL ,
`username` VARCHAR( 200 ) NOT NULL ,
INDEX (  `username` )
) ENGINE = INNODB;

ALTER TABLE `items`
  ADD CONSTRAINT `items_ibfk_1` FOREIGN KEY (`username`) REFERENCES `user` (`username`);
  
INSERT INTO `trans_db`.`user` (`username`) VALUES ('admin'), ('beku'), ('koala');

INSERT INTO `trans_db`.`items` (`id`, `name`, `username`) VALUES (NULL, 'nokia 3310', 'beku');
INSERT INTO `trans_db`.`items` (`id`, `name`, `username`) VALUES (NULL, 'acer notebook', 'beku');
INSERT INTO `trans_db`.`items` (`id`, `name`, `username`) VALUES (NULL, 'ipad 3', 'admin');


-- tamis login
CREATE DATABASE  `trans_login` ;
USE trans_login;

CREATE TABLE  `trans_login`.`user` (
`username` VARCHAR( 200 ) NOT NULL ,
PRIMARY KEY (  `username` )
) ENGINE = INNODB;

INSERT INTO `trans_login`.`user` (`username`) VALUES ('admin'), ('beku'), ('koala');

--user
CREATE USER 'router'@'%' IDENTIFIED BY  'router';

GRANT USAGE ON * . * TO  'router'@'%' IDENTIFIED BY  'router' WITH MAX_QUERIES_PER_HOUR 0 MAX_CONNECTIONS_PER_HOUR 0 MAX_UPDATES_PER_HOUR 0 MAX_USER_CONNECTIONS 0 ;

GRANT ALL PRIVILEGES ON  `trans_db` . * TO  'router'@'%';
GRANT ALL PRIVILEGES ON  `trans_login` . * TO  'router'@'%';

