create table member
(
    member_id varchar(100) not null
        primary key,
    name      varchar(100) not null,
    password  varchar(100) not null,
    role      varchar(50) not null,
    grade     varchar(50) not null
);

create table member_info
(
    member_id      varchar(100) not null
        primary key,
    email          varchar(255) not null,
    gender         varchar(255) not null,
    phone_number   varchar(255) not null,
    post_no        varchar(255) not null,
    road_address   varchar(255) not null,
    detail_address varchar(255) not null,
    birthday       date         null
);

