package com.gebarowski.michal.speculatorapi;

import com.gebarowski.michal.speculatorapi.database.spring_data_jdbc.ExchangeRateEntity;

public class MotherTestData {

    public static final Long ID_1 = 1L;
    private static final String CURRENCY_CODE_FROM_1 = "GBP";
    private static final String CURRENCY_CODE_TO_1 = "PLN";
    private static final String EXCHANGE_RATE_1 = "4.9733";
    private static final String LAST_REFRESHED_1 = "2020-01-05T20:00:02";
    private static final String BID_PRICE_1 = "4.9707";
    private static final String ASK_PRICE_1 = "4.9756";

    public static final ExchangeRateEntity EXCHANGE_RATE_ENTITY_ID_1 = ExchangeRateEntity.builder()
            .id(ID_1)
            .currencyCodeFrom(CURRENCY_CODE_FROM_1)
            .currencyCodeTo(CURRENCY_CODE_TO_1)
            .exchangeRate(EXCHANGE_RATE_1)
            .lastRefreshed(LAST_REFRESHED_1)
            .askPrice(ASK_PRICE_1)
            .bidPrice(BID_PRICE_1)
            .build();
}
