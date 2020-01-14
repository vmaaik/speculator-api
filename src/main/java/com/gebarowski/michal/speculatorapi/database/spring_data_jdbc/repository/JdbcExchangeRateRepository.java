package com.gebarowski.michal.speculatorapi.database.spring_data_jdbc.repository;

import com.gebarowski.michal.speculatorapi.database.spring_data_jdbc.ExchangeRateEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Repository
public class JdbcExchangeRateRepository implements ExchangeRateRepository, RowCallbackHandler {

    private final JdbcTemplate jdbcTemplate;

    public JdbcExchangeRateRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int save(final ExchangeRateEntity exchangeRateEntity) {
        return this.jdbcTemplate.update(
                "INSERT INTO EXCHANGE_RATE_HISTORY (id, currency_code_from, currency_code_to, exchange_rate, last_refreshed, bid_price, ask_price) " +
                        "values (?, ?, ?, ?, ?, ?, ?)",
                exchangeRateEntity.getId(),
                exchangeRateEntity.getCurrencyCodeFrom(),
                exchangeRateEntity.getCurrencyCodeTo(),
                exchangeRateEntity.getExchangeRate(),
                exchangeRateEntity.getLastRefreshed(),
                exchangeRateEntity.getBidPrice(),
                exchangeRateEntity.getAskPrice()
        );
    }

    @Override
    public Set<ExchangeRateEntity> findAll() {
        return new HashSet<>(
                this.jdbcTemplate.query(
                        "SELECT * FROM EXCHANGE_RATE_HISTORY",
                        this::mapRowToExchangeRateEntity
                )
        );
    }

    @Override
    public ExchangeRateEntity findOne(final Long id) {
        return this.jdbcTemplate.queryForObject(
                "SELECT * FROM EXCHANGE_RATE_HISTORY WHERE ID=?",
                this::mapRowToExchangeRateEntity, id
        );
    }

    @Override
    public Integer count() {
        return this.jdbcTemplate.queryForObject(
                "SELECT COUNT (*) FROM EXCHANGE_RATE_HISTORY",
                Integer.class
        );
    }

    @Override
    public List<Map<String, Object>> findAllAsMaps() {
        return this.jdbcTemplate.queryForList(
                "SELECT * FROM EXCHANGE_RATE_HISTORY"
        );
    }

    @Override
    public void processRow(final ResultSet resultSet) throws SQLException {
        mapRowToExchangeRateEntity(resultSet, resultSet.getRow()).setExchangeRate("0.00");
    }

//    public ExchangeRateEntity zeroExchangeRateVslue(final Long id) {
//        return this.jdbcTemplate.queryForObject(
//                "SELECT * FROM EXCHANGE_RATE_HISTORY WHERE ID=?",
//                this,
//                id);
//    }

    private ExchangeRateEntity mapRowToExchangeRateEntity(final ResultSet resultSet, final int rowNumber) throws SQLException {
        return ExchangeRateEntity.builder()
                .id(resultSet.getLong("id"))
                .currencyCodeFrom(resultSet.getString("currency_code_from"))
                .currencyCodeTo(resultSet.getString("currency_code_to"))
                .exchangeRate(resultSet.getString("exchange_rate"))
                .lastRefreshed(resultSet.getString("last_refreshed"))
                .bidPrice(resultSet.getString("bid_price"))
                .askPrice(resultSet.getString("ask_price"))
                .build();
    }
}
