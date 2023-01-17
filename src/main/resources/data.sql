CREATE TABLE IF NOT EXISTS `Persons` (
                                         `id` int NOT NULL AUTO_INCREMENT,
                                         `name` VARCHAR(45) NOT NULL,
                                         `surname` VARCHAR(80) NOT NULL,
                                         `birthday` date NOT NULL,
                                         PRIMARY KEY (`id`));

INSERT INTO "PERSONS" (`id`, `name`, `surname`, `birthday`) VALUES (1, 'name1', 'surname', '2000-11-20');


