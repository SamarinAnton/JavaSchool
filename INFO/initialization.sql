START TRANSACTION;
USE `trucking`;
INSERT INTO `city` (`id`, `name`, `latitude`, `longitude`) VALUES (DEFAULT, 'Moscow', 55.75, 37.62);
INSERT INTO `city` (`id`, `name`, `latitude`, `longitude`) VALUES (DEFAULT, 'Saint-Petersburg', 59.94, 30.31);
INSERT INTO `city` (`id`, `name`, `latitude`, `longitude`) VALUES (DEFAULT, 'Novosibirsk', 55.04, 82.93);
INSERT INTO `city` (`id`, `name`, `latitude`, `longitude`) VALUES (DEFAULT, 'Belgorod', 50.61, 36.58);
INSERT INTO `city` (`id`, `name`, `latitude`, `longitude`) VALUES (DEFAULT, 'Voronezh', 51.67, 39.18);
INSERT INTO `city` (`id`, `name`, `latitude`, `longitude`) VALUES (DEFAULT, 'Ekaterinburg', 56.85, 60.61);
INSERT INTO `city` (`id`, `name`, `latitude`, `longitude`) VALUES (DEFAULT, 'Kazan', 55.79, 49.12);
INSERT INTO `city` (`id`, `name`, `latitude`, `longitude`) VALUES (DEFAULT, 'Kursk', 51.74, 36.19);
INSERT INTO `city` (`id`, `name`, `latitude`, `longitude`) VALUES (DEFAULT, 'Chelyabinsk', 55.15, 61.43);
INSERT INTO `city` (`id`, `name`, `latitude`, `longitude`) VALUES (DEFAULT, 'Omsk', 54.99, 73.37);
INSERT INTO `city` (`id`, `name`, `latitude`, `longitude`) VALUES (DEFAULT, 'Samara', 53.21, 50.15);
INSERT INTO `city` (`id`, `name`, `latitude`, `longitude`) VALUES (DEFAULT, 'Kaliningrad', 54.72, 20.51);
INSERT INTO `city` (`id`, `name`, `latitude`, `longitude`) VALUES (DEFAULT, 'Ufa', 54.74, 55.97);
INSERT INTO `city` (`id`, `name`, `latitude`, `longitude`) VALUES (DEFAULT, 'Perm', 58.02, 56.25);
INSERT INTO `city` (`id`, `name`, `latitude`, `longitude`) VALUES (DEFAULT, 'Sevastopol', 44.62, 33.53);

COMMIT;


START TRANSACTION;
USE `trucking`;
INSERT INTO `user` (`id`, `login`, `password`, `status`) VALUES (DEFAULT, 'admin1', 'admin1', 'ADMIN');
INSERT INTO `user` (`id`, `login`, `password`, `status`) VALUES (DEFAULT, 'admin2', 'admin2', 'ADMIN');
INSERT INTO `user` (`id`, `login`, `password`, `status`) VALUES (DEFAULT, 'user1', 'user1', 'DRIVER');
INSERT INTO `user` (`id`, `login`, `password`, `status`) VALUES (DEFAULT, 'user2', 'user2', 'DRIVER');
INSERT INTO `user` (`id`, `login`, `password`, `status`) VALUES (DEFAULT, 'user3', 'user3', 'DRIVER');
INSERT INTO `user` (`id`, `login`, `password`, `status`) VALUES (DEFAULT, 'user4', 'user4', 'DRIVER');
INSERT INTO `user` (`id`, `login`, `password`, `status`) VALUES (DEFAULT, 'user5', 'user5', 'DRIVER');
INSERT INTO `user` (`id`, `login`, `password`, `status`) VALUES (DEFAULT, 'user6', 'user6', 'DRIVER');
INSERT INTO `user` (`id`, `login`, `password`, `status`) VALUES (DEFAULT, 'user7', 'user7', 'DRIVER');
INSERT INTO `user` (`id`, `login`, `password`, `status`) VALUES (DEFAULT, 'user8', 'user8', 'DRIVER');
INSERT INTO `user` (`id`, `login`, `password`, `status`) VALUES (DEFAULT, 'user9', 'user9', 'DRIVER');
INSERT INTO `user` (`id`, `login`, `password`, `status`) VALUES (DEFAULT, 'user10', 'user10', 'DRIVER');

COMMIT;

START TRANSACTION;
USE `trucking`;
INSERT INTO `vehicle` (`id`, `number`, `capacity`, `status`, `cities_id`, `count`)
VALUES (DEFAULT, '1234AA', 21000, DEFAULT, 1, 2 );
INSERT INTO `vehicle` (`id`, `number`, `capacity`, `status`, `cities_id`, `count`)
VALUES (DEFAULT, '1234AB', 15000, DEFAULT, 1, 2 );
INSERT INTO `vehicle` (`id`, `number`, `capacity`, `status`, `cities_id`, `count`)
VALUES (DEFAULT, '1234AC', 8000, DEFAULT, 1, 1 );
INSERT INTO `vehicle` (`id`, `number`, `capacity`, `status`, `cities_id`, `count`)
VALUES (DEFAULT, '1234AD', 10000, DEFAULT, 1, 1 );
INSERT INTO `vehicle` (`id`, `number`, `capacity`, `status`, `cities_id`, `count`)
VALUES (DEFAULT, '1234AE', 25000, DEFAULT, 1, 2 );
INSERT INTO `vehicle` (`id`, `number`, `capacity`, `status`, `cities_id`, `count`)
VALUES (DEFAULT, '1234AF', 17000, DEFAULT, 2, 2 );
INSERT INTO `vehicle` (`id`, `number`, `capacity`, `status`, `cities_id`, `count`)
VALUES (DEFAULT, '1234AG', 22000, DEFAULT, 2, 2 );
INSERT INTO `vehicle` (`id`, `number`, `capacity`, `status`, `cities_id`, `count`)
VALUES (DEFAULT, '1234AH', 22000, DEFAULT, 2, 1 );
INSERT INTO `vehicle` (`id`, `number`, `capacity`, `status`, `cities_id`, `count`)
VALUES (DEFAULT, '1234AI', 22000, DEFAULT, 2, 2 );
INSERT INTO `vehicle` (`id`, `number`, `capacity`, `status`, `cities_id`, `count`)
VALUES (DEFAULT, '1234AJ', 5000, DEFAULT, 4, 1 );
INSERT INTO `vehicle` (`id`, `number`, `capacity`, `status`, `cities_id`, `count`)
VALUES (DEFAULT, '1234AK', 12000, DEFAULT, 4, 1 );
INSERT INTO `vehicle` (`id`, `number`, `capacity`, `status`, `cities_id`, `count`)
VALUES (DEFAULT, '1234AL', 15000, DEFAULT, 4, 1 );
INSERT INTO `vehicle` (`id`, `number`, `capacity`, `status`, `cities_id`, `count`)
VALUES (DEFAULT, '1234AM', 14000, DEFAULT, 5, 1 );
INSERT INTO `vehicle` (`id`, `number`, `capacity`, `status`, `cities_id`, `count`)
VALUES (DEFAULT, '1234AN', 18000, DEFAULT, 5, 2 );
INSERT INTO `vehicle` (`id`, `number`, `capacity`, `status`, `cities_id`, `count`)
VALUES (DEFAULT, '1234AO', 16000, DEFAULT, 8, 2 );
INSERT INTO `vehicle` (`id`, `number`, `capacity`, `status`, `cities_id`, `count`)
VALUES (DEFAULT, '1234AP', 20000, DEFAULT, 12, 2 );
INSERT INTO `vehicle` (`id`, `number`, `capacity`, `status`, `cities_id`, `count`)
VALUES (DEFAULT, '1234AU', 9000, DEFAULT, 12, 1 );
INSERT INTO `vehicle` (`id`, `number`, `capacity`, `status`, `cities_id`, `count`)
VALUES (DEFAULT, '1234AR', 15000, DEFAULT, 13, 1 );
INSERT INTO `vehicle` (`id`, `number`, `capacity`, `status`, `cities_id`, `count`)
VALUES (DEFAULT, '1234AS', 22000, DEFAULT, 13, 2 );
INSERT INTO `vehicle` (`id`, `number`, `capacity`, `status`, `cities_id`, `count`)
VALUES (DEFAULT, '1234AT', 17000, DEFAULT, 15, 1 );

COMMIT;

START TRANSACTION;
USE `trucking`;
INSERT INTO `cargo` (`id`, `number`, `name`, `weight`, `status`, `cities_id`, `vehicles_id`)
VALUES (DEFAULT, 1, 'Apples', 4000, DEFAULT, 1, NULL );
INSERT INTO `cargo` (`id`, `number`, `name`, `weight`, `status`, `cities_id`, `vehicles_id`)
VALUES (DEFAULT, 2, 'Oranges', 1500, DEFAULT, 1, NULL );
INSERT INTO `cargo` (`id`, `number`, `name`, `weight`, `status`, `cities_id`, `vehicles_id`)
VALUES (DEFAULT, 3, 'Watermelons', 4000, DEFAULT, 2, NULL );
INSERT INTO `cargo` (`id`, `number`, `name`, `weight`, `status`, `cities_id`, `vehicles_id`)
VALUES (DEFAULT, 4, 'Bananas', 7000, DEFAULT, 2, NULL );
INSERT INTO `cargo` (`id`, `number`, `name`, `weight`, `status`, `cities_id`, `vehicles_id`)
VALUES (DEFAULT, 5, 'Computers', 10000, DEFAULT, 4, NULL );
INSERT INTO `cargo` (`id`, `number`, `name`, `weight`, `status`, `cities_id`, `vehicles_id`)
VALUES (DEFAULT, 6, 'Potatoes', 15000, DEFAULT, 7, NULL );
INSERT INTO `cargo` (`id`, `number`, `name`, `weight`, `status`, `cities_id`, `vehicles_id`)
VALUES (DEFAULT, 7, 'Pineapples', 3000, DEFAULT, 12, NULL );
INSERT INTO `cargo` (`id`, `number`, `name`, `weight`, `status`, `cities_id`, `vehicles_id`)
VALUES (DEFAULT, 8, 'Water', 6000, DEFAULT, 14, NULL );

COMMIT;

START TRANSACTION;
USE `trucking`;
INSERT INTO `order` (`id`, `number`, `vehicles_id`, `done`)
VALUES (DEFAULT, 1, NULL , DEFAULT );
INSERT INTO `order` (`id`, `number`, `vehicles_id`, `done`)
VALUES (DEFAULT, 2, NULL , DEFAULT );
INSERT INTO `order` (`id`, `number`, `vehicles_id`, `done`)
VALUES (DEFAULT, 3, NULL , DEFAULT );

COMMIT;


START TRANSACTION;
USE `trucking`;
INSERT INTO `driver` (`id`, `first_name`, `last_name`, `number`, `vehicles_id`, `cities_id`, `orders_id`,
                       `users_id`, `update`, `worked`, `status`)
VALUES (DEFAULT, 'Alexandr', 'Volkov', 'AA123456', NULL, 1, NULL , 3, DEFAULT, DEFAULT, DEFAULT );
INSERT INTO `driver` (`id`, `first_name`, `last_name`, `number`, `vehicles_id`, `cities_id`, `orders_id`,
                       `users_id`, `update`, `worked`, `status`)
VALUES (DEFAULT, 'Semen', 'Petrov', 'AB123456', NULL, 1, NULL , 4, DEFAULT, DEFAULT, DEFAULT );
INSERT INTO `driver` (`id`, `first_name`, `last_name`, `number`, `vehicles_id`, `cities_id`, `orders_id`,
                       `users_id`, `update`, `worked`, `status`)
VALUES (DEFAULT, 'Sergei', 'Ivanov', 'AC123456', NULL, 2, NULL , 5, DEFAULT, DEFAULT, DEFAULT );
INSERT INTO `driver` (`id`, `first_name`, `last_name`, `number`, `vehicles_id`, `cities_id`, `orders_id`,
                       `users_id`, `update`, `worked`, `status`)
VALUES (DEFAULT, 'Andrei', 'Morozov', 'AD123456', NULL, 2, NULL , 6, DEFAULT, DEFAULT, DEFAULT );
INSERT INTO `driver` (`id`, `first_name`, `last_name`, `number`, `vehicles_id`, `cities_id`, `orders_id`,
                       `users_id`, `update`, `worked`, `status`)
VALUES (DEFAULT, 'Dmitriy', 'Orlov', 'AE123456', NULL, 4, NULL , 7, DEFAULT, DEFAULT, DEFAULT );
INSERT INTO `driver` (`id`, `first_name`, `last_name`, `number`, `vehicles_id`, `cities_id`, `orders_id`,
                       `users_id`, `update`, `worked`, `status`)
VALUES (DEFAULT, 'Pavel', 'Kushnarev', 'AF123456', NULL, 8, NULL , 8, DEFAULT, DEFAULT, DEFAULT );
INSERT INTO `driver` (`id`, `first_name`, `last_name`, `number`, `vehicles_id`, `cities_id`, `orders_id`,
                       `users_id`, `update`, `worked`, `status`)
VALUES (DEFAULT, 'Maksim', 'Yakovlev', 'AG123456', NULL, 14, NULL , 9, DEFAULT, DEFAULT, DEFAULT );
INSERT INTO `driver` (`id`, `first_name`, `last_name`, `number`, `vehicles_id`, `cities_id`, `orders_id`,
                       `users_id`, `update`, `worked`, `status`)
VALUES (DEFAULT, 'Alexey', 'Murov', 'AH123456', NULL, 14, NULL , 10, DEFAULT, DEFAULT, DEFAULT );
INSERT INTO `driver` (`id`, `first_name`, `last_name`, `number`, `vehicles_id`, `cities_id`, `orders_id`,
                       `users_id`, `update`, `worked`, `status`)
VALUES (DEFAULT, 'Roman', 'Ryabov', 'AI123456', NULL, 14, NULL , 11, DEFAULT, DEFAULT, DEFAULT );
INSERT INTO `driver` (`id`, `first_name`, `last_name`, `number`, `vehicles_id`, `cities_id`, `orders_id`,
                       `users_id`, `update`, `worked`, `status`)
VALUES (DEFAULT, 'Danil', 'Belov', 'AJ123456', NULL, 14, NULL , 12, DEFAULT, DEFAULT, DEFAULT );

COMMIT;

START TRANSACTION;
USE `trucking`;
INSERT INTO `checkpoints` (`id`, `orders_id`, `cities_id`)
VALUES (DEFAULT, 1, 1);
INSERT INTO `checkpoints` (`id`, `orders_id`, `cities_id`)
VALUES (DEFAULT, 1, 2);
INSERT INTO `checkpoints` (`id`, `orders_id`, `cities_id`)
VALUES (DEFAULT, 1, 5);
INSERT INTO `checkpoints` (`id`, `orders_id`, `cities_id`)
VALUES (DEFAULT, 2, 4);
INSERT INTO `checkpoints` (`id`, `orders_id`, `cities_id`)
VALUES (DEFAULT, 2, 5);
INSERT INTO `checkpoints` (`id`, `orders_id`, `cities_id`)
VALUES (DEFAULT, 3, 2);
INSERT INTO `checkpoints` (`id`, `orders_id`, `cities_id`)
VALUES (DEFAULT, 3, 14);
INSERT INTO `checkpoints` (`id`, `orders_id`, `cities_id`)
VALUES (DEFAULT, 3, 12);

COMMIT;

START TRANSACTION;
USE `trucking`;
INSERT INTO `subtask` (`id`, `checkpoint_id`, `cargo_id`, `operation`)
VALUES (DEFAULT, 1, 1, 'LOADING');
INSERT INTO `subtask` (`id`, `checkpoint_id`, `cargo_id`, `operation`)
VALUES (DEFAULT, 1, 2, 'LOADING');
INSERT INTO `subtask` (`id`, `checkpoint_id`, `cargo_id`, `operation`)
VALUES (DEFAULT, 2, 1, 'UNLOADING');
INSERT INTO `subtask` (`id`, `checkpoint_id`, `cargo_id`, `operation`)
VALUES (DEFAULT, 3, 2, 'UNLOADING');
INSERT INTO `subtask` (`id`, `checkpoint_id`, `cargo_id`, `operation`)
VALUES (DEFAULT, 4, 5, 'LOADING');
INSERT INTO `subtask` (`id`, `checkpoint_id`, `cargo_id`, `operation`)
VALUES (DEFAULT, 5, 5, 'UNLOADING');
INSERT INTO `subtask` (`id`, `checkpoint_id`, `cargo_id`, `operation`)
VALUES (DEFAULT, 6, 3, 'LOADING');
INSERT INTO `subtask` (`id`, `checkpoint_id`, `cargo_id`, `operation`)
VALUES (DEFAULT, 6, 4, 'LOADING');
INSERT INTO `subtask` (`id`, `checkpoint_id`, `cargo_id`, `operation`)
VALUES (DEFAULT, 6, 7, 'UNLOADING');
INSERT INTO `subtask` (`id`, `checkpoint_id`, `cargo_id`, `operation`)
VALUES (DEFAULT, 7, 3, 'UNLOADING');
INSERT INTO `subtask` (`id`, `checkpoint_id`, `cargo_id`, `operation`)
VALUES (DEFAULT, 7, 8, 'LOADING');
INSERT INTO `subtask` (`id`, `checkpoint_id`, `cargo_id`, `operation`)
VALUES (DEFAULT, 8, 8, 'UNLOADING');
INSERT INTO `subtask` (`id`, `checkpoint_id`, `cargo_id`, `operation`)
VALUES (DEFAULT, 8, 4, 'UNLOADING');
INSERT INTO `subtask` (`id`, `checkpoint_id`, `cargo_id`, `operation`)
VALUES (DEFAULT, 8, 7, 'LOADING');


COMMIT;

