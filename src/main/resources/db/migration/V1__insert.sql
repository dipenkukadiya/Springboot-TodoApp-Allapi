
CREATE TABLE user_role (
    userrole_id INT AUTO_INCREMENT PRIMARY KEY,
    userrole_name VARCHAR(255) NOT NULL,
    userrole_description VARCHAR(255),
    UNIQUE (userrole_name)
);


INSERT INTO user_role (userrole_name,userrole_description)
VALUES
    ('Web Developer','this is role for web developer'),
    ('Software Engineeer','this is role for software engineer'),
    ('MEAN Stack Developer', 'this is role for MEAN '),
    ('MERN Stack Developer','this is role for MERN'),
    ('Analyses and testing', 'i am a software tester and analizer'),
    ('Project Manager', 'Project Manager Role'),
    ('Android Developer', 'i am android and flutteer developer');
