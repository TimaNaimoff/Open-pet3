DROP TABLE IF EXISTS meals;
DROP TABLE IF EXISTS users_roles;
DROP TABLE IF EXISTS users;
DROP SEQUENCE IF EXISTS GLOBAL_SEQ;


CREATE SEQUENCE GLOBAL_SEQ START 100000;
CREATE SEQUENCE MEAL_SEQ START 10000;
CREATE TABLE users(
    id integer PRIMARY KEY DEFAULT nextval('GLOBAL_SEQ'),
    name varchar(50),
	email varchar not null,
	password varchar not null,
	registered timestamp DEFAULT now(),
	enabled bool default true
);

CREATE UNIQUE INDEX unique_email ON users(email);
CREATE TABLE users_roles(
    user_id integer not null,
	role varchar ,
	CONSTRAINT user_roles_idx UNIQUE(user_id,role),
	FOREIGN KEY(user_id)REFERENCES users(id)ON DELETE CASCADE

);

CREATE TABLE meals(
    meal_id integer PRIMARY KEY DEFAULT nextval('MEAL_SEQ'),
	id integer REFERENCES users(id)ON DELETE CASCADE,
	local_date_time TIMESTAMP,
	description varchar(50)not null,
	calories int not null
);


