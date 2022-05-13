

--    This SQL querie generate a report that contains each trader's first trade for entire 2021.

select tr.id, tr.name, ts.id as trans_id, ts.trans_datetime
from trader tr 
Left join transaction ts on ts.trader_id = tr.id
where ts.trans_datetime IN (select min(trans_datetime) 
                            from transaction 
                            where trader_id= tr.id and YEAR(trans_datetime) = 2021);