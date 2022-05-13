
The application is a Spring Boot application with a rest API.

You can launch it from command line by typing `./mvnw`.
You can access the endpoints at [http://localhost:8080/reporting](http://localhost:8080/reporting):

* `/most-popular-ticker` will call  `TransactionStatistics`
* `/traders-total-traded-values/{date}` and `/first-trades-of-the-year/{year}` will call The SQL
