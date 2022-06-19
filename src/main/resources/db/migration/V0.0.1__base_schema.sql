create sequence hibernate_sequence start 1 increment 1;

CREATE TABLE public.users
(
    id         serial       not null unique,
    first_name varchar(255) not null,
    last_name  varchar(255) not null,
    card_identification varchar(255) null,
    CONSTRAINT user_pkey PRIMARY KEY (id)
);

CREATE TABLE public.animals
(
    id        serial       not null,
    name      varchar(255) not null,
    type varchar(255) not null,
    user_id   int          not null,
    CONSTRAINT animals_pkey PRIMARY KEY (id),
    constraint animals_user_fk foreign key (user_id) references public.users
);