CREATE TABLE Course
(
	courseId  integer NOT NULL,
	name  varchar(20) NULL,
	description  varchar(100) NULL,
	lector  integer NULL
);

ALTER TABLE Course
	ADD  PRIMARY KEY (courseId);

CREATE TABLE Evaluation
(
	evaluationID  integer NOT NULL,
	grade  integer NULL,
	comment  varchar(100) NULL,
	studentId  integer NULL,
	taskId  integer NULL
);

ALTER TABLE Evaluation
	ADD  PRIMARY KEY (evaluationID);

CREATE TABLE students
(
	studentId  integer NOT NULL,
	userId  integer NOT NULL,
	courseId  integer NOT NULL
);

ALTER TABLE students
	ADD  PRIMARY KEY (studentId);

CREATE TABLE Task
(
	taskId  integer NOT NULL,
	name  varchar(20) NULL,
	description  varchar(100) NULL,
	courseId  integer NULL
);

ALTER TABLE Task
	ADD  PRIMARY KEY (taskId);

CREATE TABLE User
(
	userId  integer NOT NULL,
	email  varchar(40) NULL,
	login  varchar(20) NULL,
	password  varchar(20) NULL,
	userRoleId  integer NOT NULL
);

ALTER TABLE User
	ADD  PRIMARY KEY (userId);

CREATE TABLE UserRole
(
	userRoleId  integer NOT NULL,
	userRole  varchar(20) NULL
);

ALTER TABLE UserRole
	ADD  PRIMARY KEY (userRoleId);

ALTER TABLE Course
	ADD FOREIGN KEY (lector) REFERENCES User(userId);

ALTER TABLE Evaluation
	ADD FOREIGN KEY (studentId) REFERENCES students(studentId);

ALTER TABLE Evaluation
	ADD FOREIGN KEY (taskId) REFERENCES Task(taskId);

ALTER TABLE subscribers
	ADD FOREIGN KEY (userId) REFERENCES User(userId);

ALTER TABLE subscribers
	ADD FOREIGN KEY (courseId) REFERENCES Course(courseId);

ALTER TABLE Task
	ADD FOREIGN KEY (courseId) REFERENCES Course(courseId);

ALTER TABLE User
	ADD FOREIGN KEY (userRoleId) REFERENCES UserRole(userRoleId);
