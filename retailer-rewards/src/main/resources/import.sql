-- Prepare Customer records
-- insert into customers(name) values('Ram');
-- insert into customers(name) values('Sam');
-- insert into customers(name) values('Cam');

-- Prepare transaction records

-- Aaltoo purchase
--  November
insert into purchase(purchase_date, price, customer_id, customer_name) values('2022-11-01',100,1,'Aaltoo');
insert into purchase(purchase_date, price, customer_id, customer_name) values('2022-11-05',50 ,1,'Aaltoo');
insert into purchase(purchase_date, price, customer_id, customer_name) values('2022-11-10',120,1,'Aaltoo');
-- Dec
insert into purchase(purchase_date, price, customer_id, customer_name) values('2022-12-28',50 ,1,'Aaltoo');
insert into purchase(purchase_date, price, customer_id, customer_name) values('2022-12-29',120,1,'Aaltoo');
-- January
insert into purchase(purchase_date, price, customer_id, customer_name) values('2023-01-10',80,1,'Aaltoo');
insert into purchase(purchase_date, price, customer_id, customer_name) values('2023-01-20',90 ,1,'Aaltoo');
-- Feb
insert into purchase(purchase_date, price, customer_id, customer_name) values('2023-02-14',500,1,'Aaltoo');
-- Mar
insert into purchase(purchase_date, price, customer_id, customer_name) values('2023-03-14',600,1,'Aaltoo');


-- Faltoo purchase
--  November
insert into purchase(purchase_date, price, customer_id, customer_name) values('2022-11-11',20,2,'Faltoo');
insert into purchase(purchase_date, price, customer_id, customer_name) values('2022-11-03',300 ,2,'Faltoo');
-- Jan
insert into purchase(purchase_date, price, customer_id, customer_name) values('2023-01-12',800,2,'Faltoo');
insert into purchase(purchase_date, price, customer_id, customer_name) values('2023-01-14',650,2,'Faltoo');
-- Feb
insert into purchase(purchase_date, price, customer_id, customer_name) values('2023-02-19',40,2,'Faltoo');
--  Mar
insert into purchase(purchase_date, price, customer_id, customer_name) values('2023-03-14',1000,2,'Faltoo');


-- Chaltoo purchase
--  November
insert into purchase(purchase_date, price, customer_id, customer_name) values('2022-11-01',10,3,'Chaltoo');
insert into purchase(purchase_date, price, customer_id, customer_name) values('2022-11-05',5 ,3,'Chaltoo');
--  Jan
insert into purchase(purchase_date, price, customer_id, customer_name) values('2023-01-10',8,3,'Chaltoo');
insert into purchase(purchase_date, price, customer_id, customer_name) values('2023-01-20',90 ,3,'Chaltoo');
--  Feb
insert into purchase(purchase_date, price, customer_id, customer_name) values('2023-02-14',52,3,'Chaltoo');
-- Mar
insert into purchase(purchase_date, price, customer_id, customer_name) values('2023-03-14',257,3,'Chaltoo');
