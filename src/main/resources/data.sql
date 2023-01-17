CREATE TABLE IF NOT EXISTS `Persons` (
    `id` int NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(45) NOT NULL,
    `surname` VARCHAR(80) NOT NULL,
    `birthday` date NOT NULL,
    PRIMARY KEY (`id`));

INSERT INTO persons (id, name, surname, birthday) VALUES (1, 'name1', 'surname', '2000-11-20');
INSERT INTO persons (id, name, surname, birthday) VALUES (2, 'name2', 'surname', '2000-11-20');
INSERT INTO persons (id, name, surname, birthday) VALUES (3, 'name3', 'surname', '2000-11-20');
INSERT INTO persons (id, name, surname, birthday) VALUES (4, 'name4', 'surname', '2000-11-20');


