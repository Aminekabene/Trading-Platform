
The application is a Spring Boot application with a rest API.


You can launch it from command line by typing `./mvnw`.
You can access the endpoints at [http://localhost:8080/reporting](http://localhost:8080/reporting):

* `/most-popular-ticker` will call  `TransactionStatistics`
* `/traders-total-traded-values/{date}` and `/first-trades-of-the-year/{year}` will call The SQL

Answering the 3 questions should take a maximum of 2-3 hours.

## Question 1

Your goal is to implement a method finding the most popular ticker (the symbol identifying a stock).

Read the javadoc of `src/main/java/com/tradingscreen/analytics/TransactionStatistics.java` to understand what we mean by popular.
Also read the javadoc of `Transaction` to understand the numbers you will be using.

You are free to implement the edge cases the way you want.

If you look at performance, assume a list of 1M entries and 40 different tickers.

## Question 2

We have a `Trader` class extending a `Person` class.
The task is to write appropriate `hashCode()` and `equals()` methods for both classes.

- Nothing from the source should be modified but additional fields and methods can be added.
- Instances of `Person` and `Trader` should never be equal to one another.
- A `Person` is equal to another `Person` instance if the id and name are both equal between instances.
- A `Trader` is equal to another `Trader` instance if the id, name, and city are all equal between instances.

## Question 3

You need to code 2 SQL queries.
The file `init.sql` shows the database schema and data.
Place your query in the appropriate SQL file, they will be loaded by `src/main/java/com/tradingscreen/analytics/Dao.java` to execute the query.

You can test your queries in `src/main/java/com/tradingscreen/analytics/DaoTest.java`.

### tradersTotalTradedValues.sql

Write **ONE SQL** statement to generate a report for **ALL** traders for June 2021 for their total traded values.
Please make sure you include **ALL* traders regardless if they actually trade that month.

The columns of the report are `id, name, total`.

### firstTradesOfTheYear.sql

Write **ONE SQL** to generate a report that contains each trader's first trade for entire 2021.  
It is ok to not include trader who never traded.

The columns of the report are `id, name, trans_id, trans_datetime`.

## Question 4

This is a non-technical question to get a feel of your knowledge of cryptocurrency.  There is no wrong answer.

In 10 sentences or less, explain why you think El Salvador's adoption of Bitcoin is a good or bad idea.  Include the answer in the email response to the recruiter.

