-- set up database
show databases;
create database newsapi_client;

create user 'nc_user'@'localhost' identified by 'nc_user';
create user 'nc_admin'@'localhost' identified by 'nc_admin';

GRANT ALL ON newsapi_client.* TO 'nc_admin'@'localhost' ;
GRANT SELECT, INSERT, update, delete ON newsapi_client.* TO 'nc_user'@'localhost' ;


use newsapi_client;
DROP TABLE newsapi_client.T_ARTICLE;
create table newsapi_client.T_ARTICLE (
 id INT primary key AUTO_INCREMENT,
 sourceId VARCHAR(50),
 sourceName VARCHAR(50),
 author VARCHAR(50),
 title VARCHAR(255),
 description TEXT,
 url VARCHAR(255),
 urlToImage VARCHAR(255),
 publishAt DATETIME,
 content TEXT,
 creDate DATETIME,
 creUserId VARCHAR(50),
 updDate DATETIME,
 updUserId VARCHAR(50)
);

SELECT * FROM T_ARTICLE;

--