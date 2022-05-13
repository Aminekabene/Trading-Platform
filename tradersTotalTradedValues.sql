

--  This SQL statement generate a report for **ALL** traders for June 2021 for their total traded values. This includes ALL traders regardless if they actually traded that month.

select tr.id, tr.name, sum(ts.price*ts.quantity) As Total
from trader tr
left join transaction ts on ts.trader_id = tr.id
where YEAR(ts.trans_datetime) = 2021 AND MONTH(ts.trans_datetime) = 6
Group by tr.id

Union

select id, name, 0
from trader 
where  id != (select trader_id from transaction group by trader_id having count(trader_id) > 1 )
      and id not in (select trader_id from transaction 
                      where YEAR(trans_datetime) = 2021 AND MONTH(trans_datetime) = 6);