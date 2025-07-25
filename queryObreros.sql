go
use master;
go


DROP DATABASE IF EXISTS empresa;
go
create database empresa;
go
use empresa;
go
DROP TABLE IF EXISTS obrero;
go
create table obrero(
	id int identity(1,1) primary key,
	nombre varchar(50) not null,
	apellido varchar(50) not null,
	area int not null
);
go
insert into obrero(nombre,apellido,area) values ('Carlos','Somera',1);
insert into obrero (nombre,apellido,area) values ('Saul','Rueda',1);
insert into obrero (nombre,apellido,area) values ('Pedro','Gil',1);
insert into obrero (nombre,apellido,area) values ('Jaime','Gomez',1);
insert into obrero (nombre,apellido,area) values ('Enrique','Prez',1);

select * from obrero
