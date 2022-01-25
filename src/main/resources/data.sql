/*roles*/
INSERT INTO `role` (`id`, `name`) VALUES (NULL, 'ROLE_USER');
INSERT INTO `role` (`id`, `name`) VALUES (NULL, 'ROLE_ADMIN');

/*ADMIN*/
INSERT INTO users (username,domain_user_name,first_name,last_name,password,phone_number,super_user,active_user, end_of_contract)
values ('admin@gmail.com','adminAD@domain.com','admin','admin','admin','012 638-48-12', 1, 1, null) ;

/*ADMIN ROLE*/
INSERT INTO user_role (user_id, role_id) VALUES (1,2);

/*softwareTypes*/
INSERT INTO softwaretypes (type) VALUES ('Notebook');
INSERT INTO softwaretypes (type) VALUES ('Phone');
INSERT INTO softwaretypes (type) VALUES ('Monitor');
INSERT INTO softwaretypes (type) VALUES ('Mysz');
INSERT INTO softwaretypes (type) VALUES ('Klawiatura');
INSERT INTO softwaretypes (type) VALUES ('Drukarka');
INSERT INTO softwaretypes (type) VALUES ('Router');
INSERT INTO softwaretypes (type) VALUES ('Switch');


INSERT INTO producers (name) values ('Apple');
INSERT INTO producers (name) values ('Benq');
INSERT INTO producers (name) values ('D-Link');
INSERT INTO producers (name) values ('Dell');
INSERT INTO producers (name) values ('Eizo');
INSERT INTO producers (name) values ('Epson');
INSERT INTO producers (name) values ('HP');
INSERT INTO producers (name) values ('Huawei');
INSERT INTO producers (name) values ('Logitech');
INSERT INTO producers (name) values ('NoName');
INSERT INTO producers (name) values ('Samsung');
INSERT INTO producers (name) values ('Toshiba');
INSERT INTO producers (name) values ('Xiaomi');