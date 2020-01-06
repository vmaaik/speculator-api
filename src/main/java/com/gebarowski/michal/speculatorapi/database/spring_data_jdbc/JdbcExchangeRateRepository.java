package com.gebarowski.michal.speculatorapi.database.spring_data_jdbc;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class JdbcExchangeRateRepository implements ExchangeRateRepository {

    private final JdbcTemplate jdbcTemplate;

    public JdbcExchangeRateRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int save(final ExchangeRateEntity exchangeRateEntity) {
        return 1;
    }

    @Override
    public Iterable<ExchangeRateEntity> findAll() {
        return null;
    }

    @Override
    public ExchangeRateEntity findOne(String id) {
        return this.jdbcTemplate.queryForObject("SELECT * FROM EXCHANGE_RATE_HISTORY WHERE ID=?", this::mapRowToExchangeRateEntity, id);
    }

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
