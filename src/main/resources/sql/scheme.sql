create table plants (
            plant_no bigint generated by default as identity,
            created_at timestamp,
            deleted boolean not null,
            updated_at timestamp,
            code varchar(255) not null,
            name varchar(255) not null,
            plant_type varchar(255) not null,
            primary key (plant_no)
);

create table users (
           user_no bigint generated by default as identity,
           created_at timestamp,
           deleted boolean not null,
           updated_at timestamp,
           id varchar(255) not null,
           like_plants varchar(255),
           password varchar(255) not null,
           phone varchar(255) not null,
           verified boolean default false,
           primary key (user_no)
);