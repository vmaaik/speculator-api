package com.gebarowski.michal.speculatorapi.database.spring_data_jdbc.repository;

import com.gebarowski.michal.speculatorapi.database.spring_data_jdbc.ExchangeRateEntity;

import java.util.List;
import java.util.Map;

public interface ExchangeRateRepository {

    int save(ExchangeRateEntity exchangeRateEntity);

    Iterable<ExchangeRateEntity> findAll();

    ExchangeRateEntity findOne(Long id);

    Integer count();

    List<Map<String, Object>> findAllAsMaps();

    int deleteById(final Long id);
}
