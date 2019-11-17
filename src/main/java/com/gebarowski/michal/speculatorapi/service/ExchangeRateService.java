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

    public ExchangeRateModel getExchangeRate(final String currencyFrom, final String currencyTo) {
        final Currency from = Currency.getInstance(currencyFrom);
        final Currency to = Currency.getInstance(currencyTo);

        return rateExchangeServiceGateway.getCurrencyExchangeRate(from, to)
                .getExchangeRateModel();
    }
}
