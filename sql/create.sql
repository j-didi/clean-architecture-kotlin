create table todo
(
    id uniqueidentifier not null constraint todo_pk primary key,
    description varchar(255)     not null,
    done        bit              not null
)