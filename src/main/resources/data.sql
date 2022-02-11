/*roles*/
INSERT INTO `role` (`id`, `name`) VALUES (NULL, 'ROLE_USER');
INSERT INTO `role` (`id`, `name`) VALUES (NULL, 'ROLE_ADMIN');

/*User*/
/*INSERT INTO users (username,domain_user_name,first_name,last_name,password,phone_number,super_user,active_user, end_of_contract)
values ('user@gmail.com','userAD@domain.com','user1','userLastName1','user1','012 532-41-52', 0, 1, null) ;*/

/*ADMIN ROLE*/
/*INSERT INTO user_role (user_id, role_id) VALUES (1,2);*/

/*hardware type*/
INSERT INTO hardwaretypes (type) VALUES ('Notebook');
INSERT INTO hardwaretypes (type) VALUES ('SmartPhone');
INSERT INTO hardwaretypes (type) VALUES ('Landline phone');
INSERT INTO hardwaretypes (type) VALUES ('Monitor');
INSERT INTO hardwaretypes (type) VALUES ('Mouse');
INSERT INTO hardwaretypes (type) VALUES ('Keyboard');
INSERT INTO hardwaretypes (type) VALUES ('Printer');
INSERT INTO hardwaretypes (type) VALUES ('Router');
INSERT INTO hardwaretypes (type) VALUES ('Switch');


/*software type*/
INSERT INTO softwaretypes (type) VALUES ('subscription monthly paid');
INSERT INTO softwaretypes (type) VALUES ('subscription yearly paid');
INSERT INTO softwaretypes (type) VALUES ('yearly paid');
INSERT INTO softwaretypes (type) VALUES ('freeware');
INSERT INTO softwaretypes (type) VALUES ('freemium');
INSERT INTO softwaretypes (type) VALUES ('shareware');
INSERT INTO softwaretypes (type) VALUES ('students or schools');
INSERT INTO softwaretypes (type) VALUES ('trial');
INSERT INTO softwaretypes (type) VALUES ('open source');
INSERT INTO softwaretypes (type) VALUES ('subscription cloud based MONTHLY paid');
INSERT INTO softwaretypes (type) VALUES ('subscription cloud based YEARLY paid');





/*producers*/
INSERT INTO producers (name) values ('Apple');
INSERT INTO producers (name) values ('Benq');
INSERT INTO producers (name) values ('D-Link');
INSERT INTO producers (name) values ('Dell');
INSERT INTO producers (name) values ('Eizo');
INSERT INTO producers (name) values ('Epson');
INSERT INTO producers (name) values ('HP');
INSERT INTO producers (name) values ('Huawei');
INSERT INTO producers (name) values ('Logitech');
INSERT INTO producers (name) values ('LG');
INSERT INTO producers (name) values ('NoName');
INSERT INTO producers (name) values ('Samsung');
INSERT INTO producers (name) values ('Toshiba');
INSERT INTO producers (name) values ('Xiaomi');
INSERT INTO producers (name) values ('Microsoft');

INSERT INTO hardwarequalities (description, name) VALUES ('','brand new');
INSERT INTO hardwarequalities (description, name) VALUES ('','used less than a year');
INSERT INTO hardwarequalities (description, name) VALUES ('','used between 1 and 3 years');
INSERT INTO hardwarequalities (description, name) VALUES ('','used more than 3 years');
INSERT INTO hardwarequalities (description, name) VALUES ('not know for how long','used' );
INSERT INTO hardwarequalities (description, name) VALUES ('','repaired');

INSERT INTO companies (city, description, name, nip, post_code, street, streetnumber) VALUES ('Warszawa', 'adupczyk@praxis.pl', 'Praxis S.A.', '5271004248','02-235','Równoległa','9A');
INSERT INTO companies (city, description, name, nip, post_code, street, streetnumber) VALUES ('Ożarów Mazowiecki', '', 'P.H.U. Polcan Roman Kwiatkowski', '5340016706','05-850','Poznańska','218');
INSERT INTO companies (city, description, name, nip, post_code, street, streetnumber) VALUES ('Kraków', '', 'Kserkop Sp. z o.o.', '6770024123','30-019','Mazowiecka','21');
INSERT INTO companies (city, description, name, nip, post_code, street, streetnumber) VALUES ('Kraków', '', 'Multioffice Sp. z o.o.', '6751063381','30-390','Zawiła','65d');
INSERT INTO companies (city, description, name, nip, post_code, street, streetnumber) VALUES ('Kraków', '', 'DTS Sp. z o.o. Sp.k.', '9452166838','31-331','Północna','3');