drop table if exists CUSTOMER CASCADE;
drop table if exists PRODUCT CASCADE;
--create sequence IF NOT EXISTS hibernate_sequence start with 4 increment by 1;

CREATE TABLE PRODUCT (
    name varchar(8) not null,
    unit_cost double not null,
    markup_type varchar(16) not null,
    markup double not null,
    promotion double,
    CONSTRAINT pk_product_id PRIMARY KEY (name)
);

CREATE TABLE CUSTOMER (
    id BIGINT NOT NULL,
    basic_discount FLOAT NOT NULL,
    bulk_discount_over_10k FLOAT NOT NULL,
    bulk_discount_over_30k FLOAT NOT NULL,
    CONSTRAINT pk_customer_id PRIMARY KEY (id)
);

insert into PRODUCT (name, unit_cost, markup_type, markup, promotion) values ('A', 0.52, 'PERCENTAGE', 80, null);
insert into PRODUCT (name, unit_cost, markup_type, markup, promotion) values ('B', 0.38, 'PERCENTAGE', 120, 30);
insert into PRODUCT (name, unit_cost, markup_type, markup, promotion) values ('C', 0.41, 'PER_UNIT', 0.9, null);
insert into PRODUCT (name, unit_cost, markup_type, markup, promotion) values ('D', 0.60, 'PER_UNIT', 1, 20);

insert into CUSTOMER (id, basic_discount, bulk_discount_over_10k, bulk_discount_over_30k) values ('1', 5, 0, 2);
insert into CUSTOMER (id, basic_discount, bulk_discount_over_10k, bulk_discount_over_30k) values ('2', 4, 1, 2);
insert into CUSTOMER (id, basic_discount, bulk_discount_over_10k, bulk_discount_over_30k) values ('3', 3, 1, 3);
insert into CUSTOMER (id, basic_discount, bulk_discount_over_10k, bulk_discount_over_30k) values ('4', 2, 3, 5);
insert into CUSTOMER (id, basic_discount, bulk_discount_over_10k, bulk_discount_over_30k) values ('5', 0, 5, 7);

