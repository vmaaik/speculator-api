package com.gebarowski.michal.speculatorapi.database.spring_data_jdbc;

public interface ExchangeRateRepository {

    ExchangeRateEntity save(ExchangeRateEntity exchangeRateEntity);

    Iterable<ExchangeRateEntity> findAll();

    ExchangeRateEntity findOne(String id);
}
