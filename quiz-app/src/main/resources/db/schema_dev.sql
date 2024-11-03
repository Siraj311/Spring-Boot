CREATE TABLE Question (
    id int PRIMARY KEY AUTO_INCREMENT,
    question_title varchar(100) NOT NULL,
    option1 varchar(50) NOT NULL,
    option2 varchar(50) NOT NULL,
    option3 varchar(50) NOT NULL,
    option4 varchar(50) NOT NULL,
    right_answer varchar(50) NOT NULL,
    difficulty_level varchar(50) NOT NULL,
    category varchar(50) NOT NULL
);