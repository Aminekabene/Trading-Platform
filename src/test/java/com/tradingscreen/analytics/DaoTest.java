
package com.tradingscreen.analytics;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;

/**
 * Test you can use to add test cases for your SQL queries.
 */
@SpringBootTest
class DaoTest {

    @Autowired
    private Dao dao;

    @Test
    void allTransactions() {
        List<Transaction> transactions = dao.allTransactions();
        assertThat(transactions)
                .extracting(Transaction::ticker, Transaction::quantity, Transaction::price)
                .containsExactlyInAnyOrder(
                        tuple("GOOGL", 88, 98.88),
                        tuple("AAPL", 55, 65.12),
                        tuple("IBM", 51, 51.00),
                        tuple("GOOGL", 55, 63.00)
                );
    }
}