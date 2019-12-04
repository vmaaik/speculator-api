package com.gebarowski.michal.speculatorapi.data;

public interface ExchangeRateRepository {

    ExchangeRateEntity save(ExchangeRateEntity exchangeRateEntity);

    Iterable<ExchangeRateEntity> findAll();

    ExchangeRateEntity findOne(String id);
}
