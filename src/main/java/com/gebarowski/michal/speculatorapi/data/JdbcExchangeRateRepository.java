package com.gebarowski.michal.speculatorapi.data;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcExchangeRateRepository implements ExchangeRateRepository {

    private final JdbcTemplate jdbcTemplate;

    public JdbcExchangeRateRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public ExchangeRateEntity save(ExchangeRateEntity exchangeRateEntity) {
        return null;
    }

    @Override
    public Iterable<ExchangeRateEntity> findAll() {
        return null;
    }

    @Override
    public ExchangeRateEntity findOne(String id) {
        return null;
    }
}
