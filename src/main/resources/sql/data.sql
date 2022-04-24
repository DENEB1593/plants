-- users
insert into users (`id`, `password`, `phone`, `like_plants`, `deleted`) values ('userA' , '1234', '01012341234', 'FOLIAGE,TREE,SEED', false);
insert into users (`id`, `password`, `phone`, `like_plants`, `deleted`) values ('userB' , '1235', '01012341235', 'TREE,SEED', false);
insert into users (`id`, `password`, `phone`, `like_plants`, `deleted`) values ('userC' , '1236', '01012341236', 'FOLIAGE,SEED', false);
insert into users (`id`, `password`, `phone`, `like_plants`, `deleted`) values ('userD' , '1237', '01012341237', 'FOLIAGE,TREE', false);

-- plants
insert into plants (`code`, `name`, `plant_type`, `deleted`) values ('airplant', '
공기/정화식물', 'FOLIAGE', false);
insert into plants (`code`, `name`, `plant_type`, `deleted`) values ('succlentplant', '
다육식물', 'FOLIAGE', false);
insert into plants (`code`, `name`, `plant_type`, `deleted`) values ('fruit', '열매식물', 'TREE', false);