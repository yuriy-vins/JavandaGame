-- src/main/resources/db/migration/V1__create_tables.sql
--КОРОЧЕ - ПОКА ЗАПИСИ НЕ ПЕРЕЗАПИСЫВАЮТСЯ, НУЖНО КАЖДЫЙ РАЗ ЧТО-ТО ИЗМЕНЯТЬ В ЗАПРОСЕ

-- Удаление таблицы, если она существует
DROP TABLE IF EXISTS answers;

-- Создание таблицы answers
CREATE TABLE answers (
    id SERIAL PRIMARY KEY,
    answer TEXT
);

-- Удаление таблицы, если она существует
DROP TABLE IF EXISTS questions;

-- Создание таблицы questions
CREATE TABLE questions (
    id SERIAL PRIMARY KEY,
    question TEXT,
    answer_id INT,
    FOREIGN KEY (answer_id) REFERENCES answers(id)
);




