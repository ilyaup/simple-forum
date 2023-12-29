create table User_account (
    user_id bigserial primary key,
    login varchar(20) not null unique,
    password varchar(20) not null,
    email varchar(20) not null,
    rating int default 0 not null
);

create table Post (
    post_id serial primary key,
    user_id bigint not null,
    title varchar(30) not null,
    content varchar(255) not null,
    likes bigint default 0 not null,

    constraint FK_post_user
        foreign key (user_id)
            references User_account (user_id)
);

insert into User_account (login, password, email)
    values('ilya', 1111, 'ilya@example.org'), ('vanya', 1212, 'vanya@aynav.org');