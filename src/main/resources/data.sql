INSERT INTO users (email,domain_user_name,first_name,last_name,password,phone_number,super_user,active_user, end_of_contract)
values ('admin@gmail.com','adminAD@domain.com','Jan','Administator','pass','012 638-48-12', 1, 1, null);

INSERT INTO users (email,domain_user_name,first_name,last_name,password,phone_number,super_user, active_user, end_of_contract)
values ('user1@gmail.com','user1AD@domain.com','Krzysztof','Kowalski','userpass','022 258-48-12', 0, 1, '2022-01-26');

INSERT INTO users (email,domain_user_name,first_name,last_name,password,phone_number,super_user,active_user, end_of_contract)
values ('user2@gmail.com','user2AD@domain.com','Andrzej','Łoziński','user2pass','043 482-312-22', 0, 1, '2022-02-06');