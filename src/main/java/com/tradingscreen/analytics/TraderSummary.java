
package com.tradingscreen.analytics;

import java.math.BigDecimal;

public class TraderSummary {
    private final int id;
    private final String name;
    private final BigDecimal sum;

    public TraderSummary(int id, String name, BigDecimal sum) {
        this.id = id;
        this.name = name;
        this.sum = sum;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getSum() {
        return sum;
    }

    @Override
    public String toString() {
        return "TraderSummary{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sum=" + sum +
                '}';
    }
}
