/* Query for creating projectdb schema on MySQL DB */
create database projectdb

/* Query for using the projectdb schema on MySQL DB */
use projectdb

/* Query for creating studenttab table in projectdb schema on MySQL DB */
create table studenttab(
id int PRIMARY KEY AUTO_INCREMENT,
sname varchar(20),
scourse varchar(30),
sfee int
)

/* Query for retrieving all data from studenttab table in projectdb schema on MySQL DB */
select * from studenttab