package com.tradingscreen.analytics;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/reporting")
public class AnalyticsController {

    private final TransactionStatistics transactionStatistics;
    private final Dao dao;

    public AnalyticsController(TransactionStatistics transactionStatistics, Dao dao) {
        this.transactionStatistics = transactionStatistics;
        this.dao = dao;
    }

    @GetMapping(value = "/most-popular-ticker",produces = "application/json") // GET localhost:8080/reporting/most-popular-ticker
    public ResponseEntity<String> mostPopularTicker() {
        List<Transaction> transactions = dao.allTransactions();
        String mostPopularTicker = transactionStatistics.mostPopularTicker(transactions);
        return ResponseEntity.ok(mostPopularTicker);
    }

    @GetMapping(value = "/traders-total-traded-values",produces = "application/json")
    public List<TraderSummary> allTradersTotalTradedValues() {
        return dao.allTradersTotalTradedValues();

        //return ResponseEntity.ok(traderSummaries);
    }

    @GetMapping(value = "/first-trades-of-the-year",produces = "application/json")
    public List<FirstTrade> firstTradesOfTheYear() {
        return dao.firstTradeOfTheYear();
    }
}
