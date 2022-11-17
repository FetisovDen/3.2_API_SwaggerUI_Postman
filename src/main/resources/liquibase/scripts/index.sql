-- liquibase formatted sql

-- changeset dfetisov:1
CREATE INDEX students_name_index ON students (name);

-- changeset dfetisov:2
CREATE INDEX faculties_nc_index ON faculties (name,color);