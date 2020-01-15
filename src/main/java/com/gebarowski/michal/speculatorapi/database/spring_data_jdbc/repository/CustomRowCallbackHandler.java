package com.gebarowski.michal.speculatorapi.database.spring_data_jdbc.repository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.RowCallbackHandler;

import java.sql.ResultSet;
import java.sql.SQLException;

@Slf4j
public class CustomRowCallbackHandler implements RowCallbackHandler {
    @Override
    public void processRow(ResultSet rs) throws SQLException {
        final String currencyCode = rs.getString("currency_code_from");
        final Long id = rs.getLong("id");
        if (currencyCode.equals("EUR"))
            log.info("Euro conversion found in ExchangeRate with id: " + id);
    }
}
