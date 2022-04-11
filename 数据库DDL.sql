create table class
(
    class_id   int          not null
        primary key,
    class_name varchar(255) null
);

create table course
(
    course_id   int         not null
        primary key,
    course_name varchar(10) null
);

create table course_student
(
    course_id int not null,
    stu_id    int not null,
    grade     int null
);

create table parent
(
    parent_role  varchar(10) not null,
    parent_phone varchar(11) null,
    stu_id       int         null
);

create table student
(
    id       int          not null
        primary key,
    name     varchar(255) null,
    age      int          null,
    class_id int          null
);


