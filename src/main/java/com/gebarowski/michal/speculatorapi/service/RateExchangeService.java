package com.gebarowski.michal.speculatorapi.service;

import com.gebarowski.michal.speculatorapi.gateway.RateExchangeServiceGatewy;
import com.gebarowski.michal.speculatorapi.model.CurrencyExchangeRateModel;
import org.springframework.stereotype.Service;

import java.util.Currency;

@Service
public class RateExchangeService {

    private final RateExchangeServiceGatewy rateExchangeServiceGatewy;


    public RateExchangeService(
            RateExchangeServiceGatewy rateExchangeServiceGatewy) {
        this.rateExchangeServiceGatewy = rateExchangeServiceGatewy;
    }

    public CurrencyExchangeRateModel getExchangeRate(final Currency currencyFrom, final Currency currencyTo) {
        return rateExchangeServiceGatewy.getCurrencyExchangeRate(currencyFrom, currencyTo).getCurrencyExchangeRateModel();
    }
}
