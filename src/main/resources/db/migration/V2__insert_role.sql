-- V4__create_role_table.sql

CREATE TABLE role (
    role_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    role_name VARCHAR(255) UNIQUE NOT NULL
);

-- Insert initial roles
INSERT INTO role (role_name) VALUES ('ROLE_DEVELOPER');
INSERT INTO role (role_name) VALUES ('ROLE_OWNER');
INSERT INTO role (role_name) VALUES ('ROLE_TEAMLEADER');
INSERT INTO role (role_name) VALUES ('ROLE_PROJECTMANAGER');
