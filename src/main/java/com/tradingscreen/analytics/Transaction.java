
package com.tradingscreen.analytics;

import java.util.Objects;




public class Transaction {

	/** Symbol identifying the stock */
	private final String ticker;

	/**
	 * Number of financial instruments exchanged by the transaction. A positive
	 * value is a buy, a negative value is a sale
	 */
	private final int quantity;

	/** Price paid / sold per financial instrument. Always positive */
	private final double price;

	public Transaction(String ticker, int quantity, double price) {
		this.ticker = Objects.requireNonNull(ticker);
		this.quantity = quantity;
		this.price = price;
	}

	public String ticker() {
		return ticker;
	}

	public int quantity() {
		return quantity;
	}

	public double price() {
		return price;
	}

		
	//toString
	public String toString() {
		return ticker + ", " + quantity + ", " + price;
	}
		
	//get the traded value
	public double computeTradeValue() {
		return Math.abs(quantity * price);
	}
}
