package com.gebarowski.michal.speculatorapi.database.spring_data_jdbc;

import com.gebarowski.michal.speculatorapi.model.ExchangeRateModel;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Currency;

@Component
public class ExchangeRateConverter {

    public ExchangeRateModel fromEntity(final ExchangeRateEntity entity) {

        return ExchangeRateModel.builder()
                .exchangeRate(new BigDecimal(entity.getExchangeRate()))
                .currencyCodeTo(Currency.getInstance(entity.getCurrencyCodeTo()))
                .currencyCodeFrom(Currency.getInstance(entity.getCurrencyCodeFrom()))
                .bidPrice(new BigDecimal(entity.getBidPrice()))
                .askPrice(new BigDecimal(entity.getAskPrice()))
                .lastRefreshed(LocalDateTime.parse(entity.getLastRefreshed()))
                .build();
    }

    public ExchangeRateEntity toEntity(final ExchangeRateModel model) {

        return ExchangeRateEntity.builder()
                .exchangeRate(model.getExchangeRate().toString())
                .askPrice(model.getAskPrice().toString())
                .bidPrice(model.getBidPrice().toString())
                .currencyCodeFrom(model.getCurrencyCodeFrom().toString())
                .currencyCodeTo(model.getCurrencyCodeTo().toString())
                .lastRefreshed(model.getLastRefreshed().toString())
                .build();
    }

}
