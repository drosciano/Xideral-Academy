-- Drop user first if they exist
DROP USER if exists 'jdbcstudent'@'%' ;

-- Now create user with prop privileges
CREATE USER 'jdbcstudent'@'%' IDENTIFIED BY 'jdbcstudent';

GRANT ALL PRIVILEGES ON * . * TO 'jdbcstudent'@'%';