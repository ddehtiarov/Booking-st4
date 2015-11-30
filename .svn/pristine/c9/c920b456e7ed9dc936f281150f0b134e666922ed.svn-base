CONNECT 'jdbc:derby://localhost:1527/db/bookingDB;create=true;user=root;password=root';

drop table Booking;
drop table Seat;
drop table Trip;
drop table Voyage;
drop table Station_route;
drop table Route;
drop table Benefit;
drop table Train;
drop table Station;
drop table Client;
drop table Role;

CREATE TABLE Role(
	id BIGINT NOT NULL PRIMARY KEY,
	name VARCHAR(15) NOT NULL UNIQUE
);

CREATE TABLE Client(
	id BIGINT NOT NULL generated always AS identity PRIMARY KEY,
	login VARCHAR(25) NOT NULL UNIQUE,
	password VARCHAR(32) NOT NULL,
	email VARCHAR(35) NOT NULL,
	firstname VARCHAR(25) NOT NULL,
	surname VARCHAR(25) NOT NULL,
	secondname VARCHAR(25) NOT NULL,
	role_id BIGINT NOT NULL REFERENCES Role(id) 
		ON DELETE CASCADE 
		ON UPDATE RESTRICT
);

CREATE TABLE Station(
	id BIGINT NOT NULL generated always AS identity PRIMARY KEY,
	title VARCHAR(35) NOT NULL UNIQUE
);

CREATE TABLE Train(
	id BIGINT NOT NULL generated always AS identity PRIMARY KEY,
	name VARCHAR(15) NOT NULL,
	coupe_seat INTEGER NOT NULL,
	reserved_seat INTEGER NOT NULL,
	general_seat INTEGER NOT NULL
);

CREATE TABLE Benefit(
	id BIGINT NOT NULL PRIMARY KEY,
	reason VARCHAR(30) NOT NULL UNIQUE
);

CREATE TABLE Route(
	id BIGINT NOT NULL generated always AS identity PRIMARY KEY,
	name VARCHAR(30) NOT NULL UNIQUE
);

CREATE TABLE Station_route(
	station_id BIGINT NOT NULL REFERENCES Station(id) 
		ON DELETE CASCADE 
		ON UPDATE RESTRICT,
	route_id BIGINT NOT NULL REFERENCES Route(id) 
		ON DELETE CASCADE 
		ON UPDATE RESTRICT,
	travel_time INTEGER NOT NULL,
	stop_time INTEGER NOT NULL,
	position INTEGER NOT NULL
);

CREATE TABLE Voyage(
	id BIGINT NOT NULL generated always AS identity PRIMARY KEY,
	route_id BIGINT NOT NULL REFERENCES Route(id) 
		ON DELETE CASCADE 
		ON UPDATE RESTRICT,
	train_id BIGINT NOT NULL REFERENCES Train(id) 
		ON DELETE CASCADE 
		ON UPDATE RESTRICT,
	coupe_seat INTEGER NOT NULL,
	reserved_seat INTEGER NOT NULL,
	general_seat INTEGER NOT NULL,
	arrival_time TIMESTAMP NOT NULL,
	departure_time TIMESTAMP NOT NULL
);

CREATE TABLE Trip(
	id BIGINT NOT NULL generated always AS identity PRIMARY KEY,
	station_begin_id BIGINT NOT NULL REFERENCES Station(id) 
		ON DELETE CASCADE 
		ON UPDATE RESTRICT,
	station_end_id BIGINT NOT NULL REFERENCES Station(id) 
		ON DELETE CASCADE 
		ON UPDATE RESTRICT
);

CREATE TABLE Seat(
	id BIGINT NOT NULL PRIMARY KEY,
	type VARCHAR(15) NOT NULL
);

CREATE TABLE Booking(
	id BIGINT NOT NULL generated always AS identity PRIMARY KEY,
	client_id BIGINT NOT NULL REFERENCES Client(id) 
		ON DELETE CASCADE 
		ON UPDATE RESTRICT,
	voyage_id BIGINT NOT NULL REFERENCES Voyage(id) 
		ON DELETE CASCADE 
		ON UPDATE RESTRICT,
	price INTEGER,
	benefit_id BIGINT NOT NULL REFERENCES Benefit(id) 
		ON DELETE SET DEFAULT
		ON UPDATE RESTRICT,
	trip_id BIGINT NOT NULL REFERENCES Trip(id) 
		ON DELETE CASCADE 
		ON UPDATE RESTRICT,
	seat_id BIGINT NOT NULL REFERENCES Seat(id) 
		ON DELETE SET DEFAULT
		ON UPDATE RESTRICT,
	seat_number INTEGER NOT NULL,
	date TIMESTAMP NOT NULL,
	arrival_time TIMESTAMP NOT NULL,
	departure_time TIMESTAMP NOT NULL
);

DISCONNECT;