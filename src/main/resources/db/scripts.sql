DELETE FROM users;
DELETE FROM users_roles;
ALTER SEQUENCE GLOBAL_SEQ RESTART WITH 100000;

--password
INSERT INTO users(name,password,email)VALUES
('Peter','kamaz009','petyakamaz@gmail.com');

--admin
INSERT INTO users(name,password,email)VALUES
('Akakiy','zamok123','perez123@gmail.com');

INSERT INTO users_roles(role,user_id)VALUES('ROLE_USER',100000);
INSERT INTO users_roles(role,user_id)VALUES('ROLE_ADMIN',100001);

INSERT INTO meals(id,local_date_time,description,calories)VALUES(
    100000,null,'blablabla',1000
);
INSERT INTO meals(id,local_date_time,description,calories)VALUES(
    100001,null,'Suponius',2000
);
--SELECT * FROM users us LEFT JOIN users_roles ur ON us.user_id=ur.user_id;