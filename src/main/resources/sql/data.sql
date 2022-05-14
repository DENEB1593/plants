-- users
insert into users (`id`, `password`, `phone`, `like_plants`, `deleted`) values ('userA' , '$2a$10$QgjRhlDY7uQ0EaAUCJ1bJuwMTR6GJDuc4Ce8A2wak/Uiivw.G3W0e', '01012341234', 'FOLIAGE,TREE,SEED', false);
insert into users (`id`, `password`, `phone`, `like_plants`, `deleted`) values ('userB' , '$2a$10$QgjRhlDY7uQ0EaAUCJ1bJuwMTR6GJDuc4Ce8A2wak/Uiivw.G3W0e', '01012341235', 'TREE,SEED', false);
insert into users (`id`, `password`, `phone`, `like_plants`, `deleted`) values ('userC' , '$2a$10$QgjRhlDY7uQ0EaAUCJ1bJuwMTR6GJDuc4Ce8A2wak/Uiivw.G3W0e', '01012341236', 'FOLIAGE,SEED', false);
insert into users (`id`, `password`, `phone`, `like_plants`, `deleted`) values ('userD' , '$2a$10$QgjRhlDY7uQ0EaAUCJ1bJuwMTR6GJDuc4Ce8A2wak/Uiivw.G3W0e', '01012341237', 'FOLIAGE,TREE', false);

-- plants
insert into plants (`code`, `name`, `plant_type`, `deleted`) values ('airplant', ' 공기/정화식물', 'FOLIAGE', false);
insert into plants (`code`, `name`, `plant_type`, `deleted`) values ('succlentplant', ' 다육식물', 'FOLIAGE', false);
insert into plants (`code`, `name`, `plant_type`, `deleted`) values ('fruit', '열매식물', 'TREE', false);