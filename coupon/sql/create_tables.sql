drop table if exists coupon cascade;
create table coupon
(
    id       serial
        constraint coupon_pk
            primary key,
    code     varchar,
    discount numeric,
    exp_date date
);

drop table if exists product cascade;
create table product
(
    id          serial
        constraint product_pk
            primary key,
    name        varchar,
    description varchar,
    price       numeric not null
);
