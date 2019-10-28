package com.gebarowski.michal.speculatorapi.service;

import com.gebarowski.michal.speculatorapi.gateway.RateExchangeServiceGateway;
import com.gebarowski.michal.speculatorapi.model.ExchangeRateModel;
import org.springframework.stereotype.Service;

import java.util.Currency;

@Service
public class ExchangeRateService {

    private final RateExchangeServiceGateway rateExchangeServiceGateway;


    public ExchangeRateService(
            RateExchangeServiceGateway rateExchangeServiceGateway) {
        this.rateExchangeServiceGateway = rateExchangeServiceGateway;
    }

    public ExchangeRateModel getExchangeRate(final Currency currencyFrom, final Currency currencyTo) {
        return rateExchangeServiceGateway.getCurrencyExchangeRate(currencyFrom, currencyTo).getExchangeRateModel();
    }
}
