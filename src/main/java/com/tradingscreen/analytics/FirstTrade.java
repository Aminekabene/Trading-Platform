
package com.tradingscreen.analytics;

import java.time.Instant;

public class FirstTrade {
    private final int traderId;
    private final String traderName;
    private final int transactionId;
    private final Instant transDateTime;

    public FirstTrade(int traderId, String traderName, int transactionId, Instant transDateTime) {
        this.traderId = traderId;
        this.traderName = traderName;
        this.transactionId = transactionId;
        this.transDateTime = transDateTime;
    }

    public int getTraderId() {
        return traderId;
    }

    public String getTraderName() {
        return traderName;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public Instant getTransDateTime() {
        return transDateTime;
    }

    @Override
    public String toString() {
        return "FirstTrade{" +
                "traderId=" + traderId +
                ", traderName='" + traderName + '\'' +
                ", transactionId=" + transactionId +
                ", transDateTime=" + transDateTime +
                '}';
    }
}
