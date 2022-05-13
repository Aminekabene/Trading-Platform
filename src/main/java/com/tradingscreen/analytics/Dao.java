
package com.tradingscreen.analytics;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;


@Repository
public class Dao {

    private final JdbcTemplate template;

    public Dao(DataSource dataSource) {
        template = new JdbcTemplate(dataSource);
    }

    public List<Transaction> allTransactions() {
        return template.query("select ticker, quantity, price from transaction", (resultSet, i) -> new Transaction(
                resultSet.getString("ticker"),
                resultSet.getInt("quantity"),
                resultSet.getDouble("price")
        ));
    }

    public List<TraderSummary> allTradersTotalTradedValues() {
        return template.query(loadSql("tradersTotalTradedValues.sql"), (resultSet, i) -> new TraderSummary(
                resultSet.getInt("id"),
                resultSet.getString("name"),
                resultSet.getBigDecimal("total")
        ));
    }

    public List<FirstTrade> firstTradeOfTheYear() {
        return template.query(loadSql("firstTradesOfTheYear.sql"), (resultSet, i) -> new FirstTrade(
                resultSet.getInt("id"),
                resultSet.getString("name"),
                resultSet.getInt("trans_id"),
                resultSet.getTimestamp("trans_datetime").toInstant()
        ));
    }

    private String loadSql(String filename) {
        String script;
        try {
           script = new String(Files.readAllBytes(Paths.get(filename)), StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
        return script;
    }
}
