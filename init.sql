

/*
    The following table contains Trader information

select * from  trader

 id  name    city
 --  ------  --------------
 1   Lisa    NY
 2   Tom     London
 3   Jerry   Hong Kong
 4   Kate    Los Angeles
*/
create table trader (
    id   int(11) primary key not null,
    name varchar(100) not null,
    city varchar(100) not null
);

insert into trader values(1, 'Lisa', 'NY');
insert into trader values(2, 'Tom', 'London');
insert into trader values(3, 'Jerry', 'Hong Kong');
insert into trader values(4, 'Kate', 'Los Angeles');

/*
    The following table contains trades made by trader

select * from transaction

 id  trader_id  ticker  quantity  price  trans_datetime
 --  ---------  ------  --------  -----  ---------------------
 1   1          GOOGL   88        98.88  2021-05-11 18:50:42
 2   1          AAPL    55        65.12  2021-06-15 09:06:42
 3   2          IBM     51        51     2021-05-20 11:23:42
 4   3          GOOGL   55        63     2021-06-20 21:56:42

*/
create table transaction  (
    id              int(11) primary key not null,
    trader_id       int(11) not null,
    ticker          varchar(5) not null,
    quantity      	int4 not null,
    price         	double not null,
    trans_datetime  datetime(6) not null
);

insert into transaction(id, trader_id, ticker, quantity, price, trans_datetime)
values(1, 1, 'GOOGL', 88, 98.88, '2021-05-11 18:50:42.369');
insert into transaction(id, trader_id, ticker, quantity, price, trans_datetime)
values(2, 1, 'AAPL',  55, 65.12, '2021-06-15 09:06:42.369');
insert into transaction(id, trader_id, ticker, quantity, price, trans_datetime)
values(3, 2, 'IBM',   51, 51.00, '2021-05-20 11:23:42.369');
insert into transaction(id, trader_id, ticker, quantity, price, trans_datetime)
values(4, 3, 'GOOGL', 55, 63.00, '2021-06-20 21:56:42.369');
