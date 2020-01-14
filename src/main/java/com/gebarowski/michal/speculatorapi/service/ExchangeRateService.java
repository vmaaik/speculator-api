package com.gebarowski.michal.speculatorapi.service;

import com.gebarowski.michal.speculatorapi.database.spring_data_jdbc.ExchangeRateConverter;
import com.gebarowski.michal.speculatorapi.database.spring_data_jdbc.repository.JdbcExchangeRateRepository;
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

    private final JdbcExchangeRateRepository jdbcExchangeRateRepository;

    private final ExchangeRateConverter exchangeRateConverter;

    public ExchangeRateService(
            final ExchangeRateServiceGateway exchangeRateServiceGateway,
            final JdbcExchangeRateRepository jdbcExchangeRateRepository,
            final ExchangeRateConverter exchangeRateConverter) {

        this.exchangeRateServiceGateway = exchangeRateServiceGateway;
        this.jdbcExchangeRateRepository = jdbcExchangeRateRepository;
        this.exchangeRateConverter = exchangeRateConverter;
    }

    public ExchangeRateModel getCurrentExchangeRate(final String currencyFrom, final String currencyTo) {

        final Currency from = getCurrencyInstance(currencyFrom);
        final Currency to = getCurrencyInstance(currencyTo);

        return exchangeRateServiceGateway.getCurrencyExchangeRate(from, to)
                .getExchangeRateModel();
    }

    public ExchangeRateModel getExchangeRate(final Long id) {
        return this.exchangeRateConverter.fromEntity(
                this.jdbcExchangeRateRepository.findOne(id));
    }

    private Currency getCurrencyInstance(final String currency) {
        return CURRENCY_LIST.stream()
                .filter(code -> code.equals(currency.toUpperCase()))
                .findFirst()
                .map(Currency::getInstance)
                .orElseThrow(() -> new CurrencyExchangeException("Currency code " + currency + " is not a supported code."));
    }
}
