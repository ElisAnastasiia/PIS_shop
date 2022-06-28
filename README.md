# PIS_shop

## Lab_1
### BD - MySQL
```
CREATE TABLE user (
    id serial PRIMARY KEY,
    username VARCHAR (32) NOT NULL UNIQUE,
    password VARCHAR (64) NOT NULL,
    balance INTEGER NOT NULL
);

CREATE TABLE role (
    id serial PRIMARY KEY,
    name VARCHAR (32) NOT NULL UNIQUE
);

CREATE TABLE user_role (
    user_id INTEGER  REFERENCES user (id),
    role_id INTEGER  REFERENCES role (id)
);

CREATE TABLE product (
    id serial PRIMARY KEY,
    name VARCHAR (32) NOT NULL UNIQUE,
    price INTEGER NOT NULL,
  category INTEGER NOT NULL REFERENCES category (id)
);

CREATE TABLE category (
    id serial PRIMARY KEY,
  name VARCHAR (32) NOT NULL UNIQUE
);

CREATE TABLE bucket (
    user_id INTEGER  REFERENCES user (id),
    product_id INTEGER  REFERENCES product (id)
);

INSERT INTO role (name) VALUES("admin");
```
## Lab_2
### BD - Extra inserts for database
```
INSERT INTO role (name) VALUES("admin");

INSERT INTO user_role(user_id, role_id) values(1,1);

insert into category (name) values("category1");
insert into category (name) values("category2");
insert into category (name) values("category3");
insert into category (name) values("category4");
insert into category (name) values("category5");

insert into product (name, price, category) values("product1",10,1);
insert into product (name, price, category) values("product2",10,2);
insert into product (name, price, category) values("product3",40,3);
insert into product (name, price, category) values("product4",50,4);
insert into product (name, price, category) values("product5",100,5);

insert into bucket(user_id, product_id) values(1,2);
insert into bucket(user_id, product_id) values(1,3);
```
