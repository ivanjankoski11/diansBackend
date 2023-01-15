create table "atm" (
    id bigserial not null,
    address varchar(255),
    city varchar(255),
    name varchar(255),
    primary key (id)
                   );

create table "atmposts" (
    id bigserial not null,
    content varchar(255),
    publish_date timestamp(6),
    title varchar(255),
    primary key (id)
                        );
