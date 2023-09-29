CREATE TABLE tb_task (
    id INT NOT NULL AUTO_INCREMENT,
    title VARCHAR(60),
    description VARCHAR(150) NOT NULL,
    PRIMARY KEY (id)
);

INSERT INTO tb_task (title, description) VALUES ('Task', 'Task 1');
INSERT INTO tb_task (title, description) VALUES ('Task', 'Task 2');
INSERT INTO tb_task (title, description) VALUES ('Task', 'Task 3');
INSERT INTO tb_task (title, description) VALUES ('Task', 'Task 4');
INSERT INTO tb_task (title, description) VALUES ('Task', 'Task 5');