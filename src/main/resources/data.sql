CREATE TABLE user_tb (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50),
    password VARCHAR(100),
    email VARCHAR(100),
    created_at TIMESTAMP
);

CREATE TABLE board_tb (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(200),
    content TEXT,
    user_id BIGINT,
    created_at TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES user_tb(id)
);


insert into user_tb(username, password, email, created_at)
values ('ssar', '1234', 'ssar@nate.com', CURRENT_TIMESTAMP);
insert into user_tb(username, password, email, created_at)
values ('cos', '1234', 'cos@nate.com', CURRENT_TIMESTAMP);
insert into user_tb(username, password, email, created_at)
values ('love', '1234', 'love@nate.com', CURRENT_TIMESTAMP);

insert into board_tb(title, content, user_id, created_at) values('제목1','내용1', 1, CURRENT_TIMESTAMP);
insert into board_tb(title, content, user_id, created_at) values('제목2','내용2', 1, CURRENT_TIMESTAMP);
insert into board_tb(title, content, user_id, created_at) values('제목3','내용3', 1, CURRENT_TIMESTAMP);
insert into board_tb(title, content, user_id, created_at) values('제목4','내용4', 1, CURRENT_TIMESTAMP);
insert into board_tb(title, content, user_id, created_at) values('제목5','내용5', 1, CURRENT_TIMESTAMP);