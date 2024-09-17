-- Drop user first if they exist
DROP USER if exists 'springTkd'@'%' ;

-- Now create user with prop privileges
CREATE USER 'springTkd'@'%' IDENTIFIED BY 'springTkd';

GRANT ALL PRIVILEGES ON * . * TO 'springTkd'@'%';