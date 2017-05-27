DROP TABLE IF EXISTS students;
CREATE TABLE IF NOT EXISTS students (
	id             SERIAL PRIMARY KEY,
	group_id       int NOT NULL,
	name           varchar(45) NOT NULL,
	sur_name       varchar(45) NOT NULL,
	exam_result    double precision NOT NULL,
	enrolment_date date NOT NULL
);
COPY students FROM 'C:/mytest.csv' DELIMITER ';' CSV;