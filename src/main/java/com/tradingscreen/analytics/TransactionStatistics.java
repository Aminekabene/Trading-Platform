
package com.tradingscreen.analytics;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;
import java.util.List;


@Service
public class TransactionStatistics {

    /**
     * Return the most popular ticker in terms of transaction total absolute value
     * (i.e. abs(price * quantity)). For example, let's say we have these
     * transactions:
     * <ul>
     * <li>transaction("a", -10, 2.0)</li>
     * <li>transaction("a", 20, 1.0)</li>
     * <li>transaction("b", 5, 1.0)</li>
     * <li>transaction("b", 10, 1.0)</li>
     * <li>transaction("b", 10, 1.0)</li>
     * </ul>
     * The most popular one ticker is "a" with a traded value of 40 compared to b
     * that only has 25.
     */
	public String mostPopularTicker(List<Transaction> transactions) {

		//We will use a hashmap to store each ticker and its total traded value
		Map<String, Double> tickerToTradingValue = new HashMap<>();

		transactions
				.stream()
						.forEach( transaction -> {
							boolean isTickerInMap = tickerToTradingValue.containsKey(transaction.ticker());
							Double tradedValue = tickerToTradingValue.get(transaction.ticker());
							if (isTickerInMap == false) {
								//if we never met the ticker we add it to the map
								tickerToTradingValue.put(transaction.ticker(), transaction.computeTradeValue());
							} else {
								//if the ticker is already in the map we update its traded value
								tickerToTradingValue.put(transaction.ticker(), tradedValue + transaction.computeTradeValue());
							}
						});

		// Now it's just a question of finding the ticker with the largest Traded Value
		Double largestTradedValue = Double.MIN_VALUE;
		String mostPopularTicker ="";
		for ( Map.Entry<String, Double> entry: tickerToTradingValue.entrySet()) {
			if (entry.getValue() >= largestTradedValue) {
				largestTradedValue = entry.getValue();
				mostPopularTicker = entry.getKey();
			}
		}

		return mostPopularTicker;
	    }
}
