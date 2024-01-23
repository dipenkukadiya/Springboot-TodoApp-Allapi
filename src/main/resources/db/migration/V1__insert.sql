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
    ('web developer', 'Key1', 'Description1'),
    ('software enginner', 'Key2', 'Description2'),
    ('mean stack', 'Key3', 'Description3'),
    ('mern stack', 'Key4', 'Description4'),
    ('team leader', 'Key5', 'Description5'),
    ('analysy and testing', 'Key6', 'Description6'),
    ('project manager', 'Key7', 'Description7'),
    ('android developer', 'Key8', 'Description8');
