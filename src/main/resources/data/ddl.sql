show databases;
show tables;
SHOW VARIABLES ; -- LIKE "%version%";
 
CREATE DATABASE antSmash;
 
CREATE USER 'SAM'@'localhost' IDENTIFIED BY 'SAM';
CREATE USER 'user'@'localhost' IDENTIFIED BY 'password';
CREATE USER 'root'@'localhost'  IDENTIFIED BY 'password';
select * from mysql.user;
GRANT ALL PRIVILEGES ON * . * TO 'SAM'@'localhost';
GRANT ALL PRIVILEGES ON * . * TO 'user'@'localhost';
GRANT ALL PRIVILEGES ON * . * TO 'root'@'localhost';
select * from mysql.user;
select user();
use XXX;
 

 
 ALTER TABLE  flights ADD partition_index2 int(11);
 
  
 
