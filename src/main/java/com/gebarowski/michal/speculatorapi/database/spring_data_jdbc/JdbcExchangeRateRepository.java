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
    public ExchangeRateEntity save(ExchangeRateEntity exchangeRateEntity) {
        return null;
    }

    @Override
    public Iterable<ExchangeRateEntity> findAll() {
        return null;
    }

    @Override
    public ExchangeRateEntity findOne(String id) {

        return jdbcTemplate.queryForObject("select id, dbTest from Test where id=?",
                this::mapRowToExchangeRateEntity, id);
    }

    private ExchangeRateEntity mapRowToExchangeRateEntity(ResultSet resultSet, int rowNumber) throws SQLException {

        return ExchangeRateEntity.builder()
                .id(resultSet.getLong("id"))
                .dbTest(resultSet.getString("dbTest"))
                .build();

    }
}
