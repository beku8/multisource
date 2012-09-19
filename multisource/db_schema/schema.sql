CREATE DATABASE  `router_1` ;
CREATE DATABASE  `router_2` ;
CREATE DATABASE  `router_3` ;

CREATE TABLE  `router_1`.`item` (
`name` VARCHAR( 100 ) NOT NULL ,
`price` DOUBLE NULL DEFAULT NULL ,
PRIMARY KEY (  `name` )
) ENGINE = INNODB;

CREATE TABLE  `router_2`.`item` (
`name` VARCHAR( 100 ) NOT NULL ,
`price` DOUBLE NULL DEFAULT NULL ,
PRIMARY KEY (  `name` )
) ENGINE = INNODB;

CREATE TABLE  `router_3`.`item` (
`name` VARCHAR( 100 ) NOT NULL ,
`price` DOUBLE NULL DEFAULT NULL ,
PRIMARY KEY (  `name` )
) ENGINE = INNODB;



INSERT INTO `router_1`.`item` (`name`, `price`) VALUES ('Windows Vista', '200');
INSERT INTO `router_1`.`item` (`name`, `price`) VALUES ('Windows 7', '210.65');
INSERT INTO `router_1`.`item` (`name`, `price`) VALUES ('Mac OS', '130');

INSERT INTO `router_2`.`item` (`name`, `price`) VALUES ('Kaspersky IS', '51.5');
INSERT INTO `router_2`.`item` (`name`, `price`) VALUES ('Avast', '10.5');

INSERT INTO `router_3`.`item` (`name`, `price`) VALUES ('Visual Studio', '100');
INSERT INTO `router_3`.`item` (`name`, `price`) VALUES ('MyEclipse', '10');
INSERT INTO `router_3`.`item` (`name`, `price`) VALUES ('Eclipse', '0');
INSERT INTO `router_3`.`item` (`name`, `price`) VALUES ('STS', '0');

-- user section
CREATE USER 'router'@'%' IDENTIFIED BY  'router';

GRANT USAGE ON * . * TO  'router'@'%' IDENTIFIED BY  'router' WITH MAX_QUERIES_PER_HOUR 0 MAX_CONNECTIONS_PER_HOUR 0 MAX_UPDATES_PER_HOUR 0 MAX_USER_CONNECTIONS 0 ;

GRANT ALL PRIVILEGES ON  `router_1` . * TO  'router'@'%';
GRANT ALL PRIVILEGES ON  `router_2` . * TO  'router'@'%';
GRANT ALL PRIVILEGES ON  `router_3` . * TO  'router'@'%';

