create database UAS;
use UAS;
create table biodata(
id int primary key,
nama varchar(15),
jk enum('L','P'),
alamat varchar(30),
email varchar(30)
);