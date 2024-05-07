create database jspdb;

create user jsp identified by 'pass';
grant all privileges on jspdb.* to jsp@'%';


create database nodesadb;
create user node identified by 'pass';
grant all privileges on nodedb.* to haksa@'%';

create database haksadb;
create user haksa identified by 'pass';
grant all privileges on haksadb.* to haksa@'%';