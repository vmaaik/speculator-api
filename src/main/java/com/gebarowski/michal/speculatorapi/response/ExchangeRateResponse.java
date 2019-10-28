package com.gebarowski.michal.speculatorapi.response;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.gebarowski.michal.speculatorapi.model.ExchangeRateModel;

public class ExchangeRateResponse {

    @JsonAlias("Realtime Currency Exchange Rate")
    private ExchangeRateModel exchangeRateModel;

    public ExchangeRateModel getExchangeRateModel() {
        return exchangeRateModel;
    }
}
