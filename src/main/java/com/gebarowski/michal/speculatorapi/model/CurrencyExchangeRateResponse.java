package com.gebarowski.michal.speculatorapi.model;

import com.fasterxml.jackson.annotation.JsonAlias;

public class CurrencyExchangeRateResponse {

    @JsonAlias("Realtime Currency Exchange Rate")
    private CurrencyExchangeRateModel currencyExchangeRateModel;

    public CurrencyExchangeRateModel getCurrencyExchangeRateModel() {
        return currencyExchangeRateModel;
    }
}
