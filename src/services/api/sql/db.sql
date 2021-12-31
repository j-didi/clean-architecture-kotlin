USE master;
CREATE DATABASE Todo;
GO

USE Todo;
CREATE TABLE Todo
(
    id uniqueidentifier not null constraint todo_pk primary key,
    description varchar(255)     not null,
    done        bit              not null
);