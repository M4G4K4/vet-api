CREATE TABLE public.users
(
    id         varchar(255)       not null unique,
    first_name varchar(255) not null,
    last_name  varchar(255) not null,
    email varchar(255) not null,
    phone_number varchar(255) null,
    card_identification varchar(20) null,
    nif varchar(20) null,
    CONSTRAINT user_pkey PRIMARY KEY (id)
);

CREATE TABLE public.animals
(
    id        varchar(255)       not null,
    name      varchar(255) not null,
    type varchar(255) not null,
    user_id   varchar(255)          not null,
    sex varchar(10) not null,
    CONSTRAINT animals_pkey PRIMARY KEY (id),
    constraint animals_user_fk foreign key (user_id) references public.users
);
