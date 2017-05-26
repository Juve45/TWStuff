CREATE TABLE IF NOT EXISTS users
(
    id_user VARCHAR(30) NOT NULL,
    name VARCHAR(50),
    profile_image_url VARCHAR(1000) UNIQUE,
    birthday DATE,
    school VARCHAR(30),
    session_id VARCHAR(200) UNIQUE,
    PRIMARY KEY(id_user)
);

CREATE TABLE IF NOT EXISTS resources
(
    id_resource VARCHAR(100) NOT NULL,
    created_at DATE,
    resorce_type VARCHAR(30) NOT NULL,
    PRIMARY KEY(id_resource)
);

CREATE TABLE IF NOT EXISTS resources_tags
(
    id_resource VARCHAR(100) NOT NULL references resources(id_resource) ,
    tag VARCHAR(100) NOT NULL,
    PRIMARY KEY(id_resource,tag)
);

CREATE TABLE IF NOT EXISTS resources_users
(
    id_user VARCHAR(30) NOT NULL references users(id_user) ,
    id_resource VARCHAR(100) NOT NULL UNIQUE references resources(id_resource) ,
    PRIMARY KEY(id_user, id_resource)
);
ALTER TABLE resources ADD COLUMN path varchar(50);
UPDATE resources SET path = '/';    -- Just a silly example
ALTER TABLE resources ALTER COLUMN path SET NOT NULL;