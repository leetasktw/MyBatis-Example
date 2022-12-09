create table tb_user(
                        id INT NOT NULL AUTO_INCREMENT,
                        username VARCHAR(20) NOT NULL,
                        password VARCHAR(40) NOT NULL,
                        phone VARCHAR(16) NOT NULL,
                        PRIMARY KEY ( id )
);

insert into tb_user (username, password, phone)
values ('張三', '1A100D2C0DAB19C4430E7D73762B3423', '0913123456'),
       ('李四', '73882AB1FA529D7273DA0DB6B49CC4F3', '0914123456'),
       ('王五', '5B1B68A9ABF4D2CD155C81A9225FD158', '0915123456'),
       ('趙六', 'F379EAF3C831B04DE153469D1BEC345E', '0916123456');


create table tb_order(
                         id INT NOT NULL AUTO_INCREMENT,
                         order_id VARCHAR(20) NOT NULL,
                         product_name VARCHAR(40) NOT NULL,
                         price INT NOT NULL,
                         create_time DATE,
                         PRIMARY KEY ( id )
);

insert into tb_order (order_id, product_name, price, create_time)
values ('20221201120101', '電線', 100, '2022-12-01'),
       ('20221201120202', '鬧鐘', 200, '2022-12-02'),
       ('20221201120303', '模型', 300, '2022-12-03'),
       ('20221201120404', '滑鼠', 400, '2022-12-04'),
       ('20221201120505', '鍵盤', 500, '2022-12-05');