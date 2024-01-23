-- V1__create_user_role_table.sql

-- Create user_role table
CREATE TABLE user_role (
    role_id INT AUTO_INCREMENT PRIMARY KEY,
    role_name VARCHAR(255) NOT NULL,
    role_key VARCHAR(255) NOT NULL,
    role_description VARCHAR(255),
    UNIQUE (role_name)
);

-- Insert initial data
INSERT INTO user_role (role_name, role_key, role_description)
VALUES
    ('Web Developer', 'Key1', 'this is role for web developer'),
    ('Software Engineeer', 'Key2', 'this is role for software engineer'),
    ('MEAN Stack Developer', 'Key3', 'this is role for MEAN '),
    ('MERN Stack Developer', 'Key4', 'this is role for MERN'),
    ('Team Leader', 'Key5', 'i am team leader'),
    ('Analyses and testing', 'Key6', 'i am a software tester and analizer'),
    ('Project Manager', 'Key7', 'Project Manager Role'),
    ('Android Developer', 'Key8', 'i am android and flutteer developer');
