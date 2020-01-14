package com.gebarowski.michal.speculatorapi.database.spring_data_jdbc.repository;

import com.gebarowski.michal.speculatorapi.database.spring_data_jdbc.ExchangeRateEntity;

public interface ExchangeRateRepository {

    int save(ExchangeRateEntity exchangeRateEntity);

    Iterable<ExchangeRateEntity> findAll();

    ExchangeRateEntity findOne(Long id);
}
