package com.gebarowski.michal.speculatorapi.service;

import com.gebarowski.michal.speculatorapi.gateway.ExchangeRateServiceGateway;
import com.gebarowski.michal.speculatorapi.model.ExchangeRateModel;
import com.gebarowski.michal.speculatorapi.service.exception.CurrencyExchangeException;
import org.springframework.stereotype.Service;

import java.util.Currency;
import java.util.List;

@Service
public class ExchangeRateService {

    // TODO: Add support for the Forex currency list
    private static final List<String> CURRENCY_LIST = List.of("USD", "PLN", "GBP", "EUR");

    private final ExchangeRateServiceGateway exchangeRateServiceGateway;

    public ExchangeRateService(
            ExchangeRateServiceGateway exchangeRateServiceGateway) {
        this.exchangeRateServiceGateway = exchangeRateServiceGateway;
    }

    public ExchangeRateModel getExchangeRate(final String currencyFrom, final String currencyTo) {

        final Currency from = getCurrencyInstance(currencyFrom);
        final Currency to = getCurrencyInstance(currencyTo);

        return exchangeRateServiceGateway.getCurrencyExchangeRate(from, to)
                .getExchangeRateModel();
    }

    private Currency getCurrencyInstance(final String currency) {
        return CURRENCY_LIST.stream()
                .filter(code -> code.equals(currency.toUpperCase()))
                .findFirst()
                .map(Currency::getInstance)
                .orElseThrow(() -> new CurrencyExchangeException("Currency code " + currency + " is not a supported code."));
    }
}
